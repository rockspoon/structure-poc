package com.example.poc.client.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.nsd.NsdManager
import android.net.nsd.NsdServiceInfo
import android.os.IBinder
import android.util.Log
import com.example.poc.client.loadModules
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import java.net.InetAddress
import java.net.ServerSocket
import java.util.concurrent.TimeUnit

/**
 * Service that receives income push messages from application acting
 * as a server on the local network.
 */
class ClientService : Service(), KoinComponent {

    private val nsdManager: NsdManager by lazy {
        getSystemService(Context.NSD_SERVICE) as NsdManager
    }

    private val serverSocket: ServerSocket by lazy {
        // Initialize a server socket on the next available port.
        ServerSocket(0)
    }

    private var serviceName: String? = null

    private val syncEndpoint: SyncEndpoint by inject()

    override fun onCreate() {

        // Load Koin modules
        loadModules()

        registerService()
    }

    override fun onBind(intent: Intent?): IBinder? {
        // TODO return a IBinder so the activity that instantiated it can communicate with it?
        return null
    }

    /**
     * Register the service for network discovering
     *
     * The port and service type comes from IANA. See
     * [IANA service name for http protocol](https://www.iana.org/assignments/service-names-port-numbers/service-names-port-numbers.xhtml?search=http)
     */
    private fun registerService(port: Int = 80) {
        // Create the NsdServiceInfo object, and populate it.
        val serviceInfo = NsdServiceInfo().apply {
            // The name is subject to change based on conflicts
            // with other services advertised on the same network.
            serviceName = defaultServiceName
            serviceType = "_http._tcp"
            setPort(port)
        }

        nsdManager.registerService(
            serviceInfo,
            NsdManager.PROTOCOL_DNS_SD,
            object : NsdManager.RegistrationListener {

                override fun onServiceRegistered(NsdServiceInfo: NsdServiceInfo) {
                    // Save the service name. Android may have changed it in order to
                    // resolve a conflict, so update the name you initially requested
                    // with the name Android actually used.
                    serviceName = NsdServiceInfo.serviceName

                    //initializeServerSocket()
                    // or
                    startSeverEngine()
                }

                override fun onRegistrationFailed(serviceInfo: NsdServiceInfo, errorCode: Int) {
                    // Registration failed! Put debugging code here to determine why.
                }

                override fun onServiceUnregistered(arg0: NsdServiceInfo) {
                    // Service has been unregistered. This only happens when you call
                    // NsdManager.unregisterService() and pass in this listener.
                }

                override fun onUnregistrationFailed(serviceInfo: NsdServiceInfo, errorCode: Int) {
                    // Un-registration failed. Put debugging code here to determine why.
                }
            }
        )
    }

    /**
     * Starts the sever engine using Ktor and Netty engine.
     */
    private fun startSeverEngine() {

        // Use the sever socket just to find a unused port
        val port = serverSocket.localPort
        serverSocket.close()

        val engine = embeddedServer(
            factory = Netty,
            port = port, // or 80, but may not be available
            host = "0.0.0.0"
        ) {
            routing {
                syncEndpoint
            }
        }

        engine.addShutdownHook {
            engine.stop(3, 5, TimeUnit.SECONDS)
        }

        engine.start(wait = true)

        val hostName = InetAddress.getLocalHost().hostName
        Log.i(defaultServiceName, "Sever started at $hostName:$port")
    }

    companion object {
        const val defaultServiceName = "PocLocalServer"
    }
}
# Migration process

## Option 1: New project

Avoid the sunk cost bias and create a new project and use the old just as a helper.

The design of the old is bad, the architecture are not always following the MVVM pattern, the dependency graph is very complicated, there is a lot of unused classes, and the problems goes on.

## Option 2: Merging modules

1. Merge the api, ui, and implementation feature modules in one module;
2. Refactor the classes to the correct packages;
3. Create the new core modules and refactor them;
4. Delete unused modules;
5. ...

The prospects for this way is bad. The refactor of *BrainJet Intellij*, even though being good is not good enough. There is a lot of references hardcoded in strings and included in non build gradle files that can't be refactored automatically. Some dependencies will be circular if it’s done this way because feature module is depending on feature module.

## Option 3: Refactoring classes to core

1. Create a proof of concept to anticipate common problems.
2. Create the core projects and put all feature modules depending on them. Core modules are independent of each other but their activities, services, and etc may communicate using the class that instantiate as mediator / single source of truth, just like fragments does with view models and activities;
3. Migrate the Rest API classes out, to another repository;
4. Migrate the entities and repositories to core-data project without changing packages names of the classes. This and step 2 is probably the biggest cause of dependency between feature modules;
5. Slowly migrate other classes to core-[architecturelayer] modules, again without changing their package name;
6. Feature module by feature module, try to remove dependency against other feature modules, again one by one. Run tests after each dependency removed; Do this for one as a test;
7. Left it for a week. Any bug introduced in this module feature by the refactoring that was not caught on the compilation and tests should be documented so new refactors pay attention for those bugs and test against it. For this is good to implement jetpack navigation in :app module.
8. Do this for all modules. When they all independent of other feature modules (except the dependency between the ui, api, and implementation), try to merge the modules.
9. Feature module by feature module rename packages. This can be made in parallel by multiple developers as they are now independents.
10. Finally, start to rename packages of core modules. Since every project depend on them, this will need to be a task for a single developer and the work of others will need to be halt to avoid an huge merge conflict. So every developer will commit and push their work on a Friday to its feature branch, a new branch will be created from developer, this branch will be merged with each feature branch commits, then during the two days of weekend the refactoring will be done and merged. On Monday the developers will resume their work starting by merging back from dev accepting all merge conflicts from the develop side.


## Roadmap

- [x] Create project
- [x] Add modules
- [x] Refactor fragment to dynamic feature module
- [x] Add dependencies
- [x] Add Koin dependency injection
- [x] Add a RetroFit client in :datasource_network
- [x] Add a Resource in :datasource_network
- [x] Add a Database in :datasource_database
- [x] Add a Entity in :datasource_database
- [x] Add a database DataSource in :core_data
- [x] Add a network DataSource in :core_data
- [x] Add a Repository(dataSource1, dataSource2) in :core_data, with database cache implementation using Koin constructor injection
- [x] Add a UseCase(repository) in :core_domain
- [x] Add a ViewModel(useCase) in :feature_home
- [x] Add a view model to :feature_auth fragment
- [x] Add material design dependency to :core_ui
- [x] Display the data in the fragment using :core_ui material component
- [x] Add an unit test in :feature module with Flow
- [x] Add an instrumented test in a dynamic feature module
- [x] Add an non-dynamic feature module 
- [x] Test the non-dynamic feature with dependency injection in it’s own module
- [x] Add an instrumented test in non-dynamic module with dependency injection of a fake DataSource module
- [x] Add an integration end-to-end test in :app
- [ ] Make a receiver in :core_receiver getting user data from another app in the network
- [ ] Make the receiver use the Repository to pull new data
- [ ] Make a provider in :core_provider
- [ ] Make the provider provide database data to system contacts
- [ ] Make a service in :core_service
- [ ] Start the service from :feature_search
- [ ] Make auth feature independent of :core by inserting new users in system accounts manager
- [x] Macrobenchmark :app startup
- [ ] Microbenchmark the :datasource_database insertions


## Contributing to this document

This document is a guide and it's subject to updates. If you have a suggestion or a problem that arise from applying its guidelines you should discuss it with other team members and update it.

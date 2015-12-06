/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    $urlRouterProvider.otherwise("/home1");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider
       
       .state('home1', {
 
            url: "/home1",
            templateUrl: "views/home1.html",
        })  

        .state('register', {
            url: "/register",
            templateUrl: "views/register.html"
        })

        .state('login', {
            url: "/login",
            templateUrl: "views/login.html"
        })

        .state('home2', {
            url: "/home2",
            templateUrl: "views/home2.html"
        })


        .state('profile', {
            url: "/profile",
            templateUrl: "views/profile.html"
        })

        .state('notify', {
            url: "/notify",
            templateUrl: "views/create-violation.html"
        })

        .state('viewVio', {
            url: "/viewVio",
            templateUrl: "views/viewViolation.html"
        })

        .state('info', {
            url: "/viewVio/techInfo",
            templateUrl: "views/techInfo.html"
        })

        .state('advancedsearch', {
            url: "/advancedsearch.html",
            templateUrl: "views/advancedsearch.html"
        })


        
   
}
angular
    .module('inspinia')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });

(function() {
    'use strict';

    angular.module('productSelectionApp')
            .config(stateConfig);

    stateConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
        $stateProvider.state('app', {
            abstract: true,
            views: {
                'navbar@': {
                    templateUrl: '/app/navbar/navbar.html',
                    controller: 'NavbarController'
                }
            }
        })
    }
})();
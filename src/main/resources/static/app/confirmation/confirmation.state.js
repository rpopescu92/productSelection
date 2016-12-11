(function() {
    'use strict';

    angular.module('productSelectionApp')
            .config(stateConfig);

    stateConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/home');

        $stateProvider.state('confirmation', {
            url: '/confirmation?selections&customerId',
            parent: 'app',
            views: {
                'content@': {
                    templateUrl: '/app/confirmation/confirmation.html',
                    controller: 'ConfirmationController'
                }
            }
        });
    }
})();
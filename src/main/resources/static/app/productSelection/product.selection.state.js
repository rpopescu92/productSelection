(function() {
    'use strict';

    angular.module('productSelectionApp')
            .config(stateConfig);

    stateConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/home');

        $stateProvider.state('home', {
            url: '/home',
            parent: 'app',
            views: {
                'content@': {
                    templateUrl: '/app/productSelection/product.selection.html',
                    controller: 'ProductSelectionController'
                }
            }
        });
    }
})();
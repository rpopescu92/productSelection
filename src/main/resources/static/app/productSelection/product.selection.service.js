(function() {
    'use strict';

    angular.module('productSelectionApp')
            .service('ProductSelectionService', ProductSelectionService);

    ProductSelectionService.$inject = ['$http'];

    function ProductSelectionService($http) {

        return {
            getCatalogue: getCatalogue,
            getCustomerLocation: getCustomerLocation
        }

        function getCustomerLocation(customerId) {
            return $http({
                url: '/api/customer-location/' + customerId,
                method: 'GET'
            })
        }
        function getCatalogue(locationId) {
            return $http({
                url: '/api/catalogue/' + locationId,
                method: 'GET'
            });
        }
    }
}) ();
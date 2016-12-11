(function() {
    'use strict';

    angular.module('productSelectionApp')
            .controller('ProductSelectionController',ProductSelectionController);

     ProductSelectionController.$inject = ['$scope', '$state', 'ProductSelectionService'];

     function ProductSelectionController($scope, $state, ProductSelectionService) {
        $scope.customerId = "customer1";
        $scope.locationId;
        $scope.catalogue = [];
        $scope.selections = [];
        $scope.products = [];
        $scope.locationError = false;

        $scope.addToCheckout = addToCheckout;
        $scope.goToConfirmation = goToConfirmation;

        init();

        function init() {
            ProductSelectionService.getCustomerLocation($scope.customerId)
                        .then(function(data) {
                            ProductSelectionService.getCatalogue(data.data.locationID)
                                    .then(function(data) {
                                        $scope.catalogue = data.data.productsByCategory;
                                    });
                            $scope.locationError = false;
                        },
                          function(error) {
                              $scope.locationError = true;
                          });
        }

        function addToCheckout(product) {
            var index = $scope.selections.indexOf(product);
            if(index != -1) {
               $scope.selections.splice(index,1);
            } else {
                $scope.selections.push(product);
          }
        }

        function goToConfirmation() {
            $state.go('confirmation', {selections: $scope.selections, customerId: $scope.customerId});
        }
     }
})();
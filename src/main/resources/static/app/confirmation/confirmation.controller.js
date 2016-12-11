(function() {

    'use strict';

    angular.module('productSelectionApp')
            .controller('ConfirmationController', ConfirmationController);

    ConfirmationController.$inject = ['$scope', '$stateParams'];

    function ConfirmationController($scope, $stateParams) {

        $scope.customerId = $stateParams.customerId;
        $scope.selections = $stateParams.selections;

    }
})();
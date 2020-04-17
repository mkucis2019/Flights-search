app.controller('airportController', function($scope, $http) {
   $http.get(server + "/data/airport")
   .then(function (response) {$scope.airports = response.data;});
});

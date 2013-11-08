
/* Controllers */

var incidentControllers = angular.module('incidentControllers', []);

incidentControllers.controller('IncidentListCtrl', ['$scope', '$http', 
	function IncidentsListCtrl($scope,$http) {
		console.log("Start");
		/*$http.get('http://localhost:8080/Inc1/rest/incidents').success(function(data) {*/
		$http({method: 'GET', url: 'http://localhost:8080/Inc1/rest/incidents'}).success(function(data) {
			console.log("Loaded");
			/* 
			 * Read data from nested JSON pattern: data.level1.level2
			 * http://stackoverflow.com/questions/16377529/using-deeply-nested-object-from-json-in-angularjs-strange-behavior 
			 */
			$scope.incidents = data.incident;
			console.log($scope.incidents);
		});
	
	$scope.orderProp = 'id';
	}]);

incidentControllers.controller('IncidentDetailCtrl', ['$scope', '$routeParams', '$http', 
	function($scope, $routeParams, $http) {
		$http.get('http://localhost:8080/Inc1/rest/incidents').success(function(data) {
			/*$scope.incidents = data.slice(0, 5);*/
			
			angular.forEach(data.incident, function(item) {
				/*console.log(item.id);*/
				if (item.id == $routeParams.incidentId) {
					$scope.incident = item;
					/*console.log("EQUAL");*/
					/*console.log(item);*/
					}
			});
			
			/*$scope.incidents = function(data) {
				return data.id === $routeParams.incidentId;
			};*/
	
		});
		
	$scope.incidentId = $routeParams.incidentId;
}]);

incidentControllers.controller('IncidentAddCtrl', ['$scope', '$http', 
	function IncidentAddCtrl($scope, $http) {
		$scope.save = function() {
			/*$http.put('/save.py', $scope.incident);*/
			console.log($scope.incident);
		};
	}
]);
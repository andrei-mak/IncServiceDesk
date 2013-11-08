var incidentsApp = angular.module('incidentsApp', [
	'ngRoute',
	'incidentControllers',
	'incidentServices'
]);

incidentsApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/incidents', {
				templateUrl: 'partials/incident-list.html',
				controller: 'IncidentListCtrl'
			}).
			when('/incidents/add', {
				templateUrl: 'partials/incident-add.html',
				controller: 'IncidentAddCtrl'
			}).
			when('/incidents/:incidentId', {
				templateUrl: 'partials/incident-details.html',
				controller: 'IncidentDetailCtrl'
			}).
			otherwise({
				redirectTo: '/incidents'
			});
	}]);
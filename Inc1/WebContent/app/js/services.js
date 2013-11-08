
/* Services */

var incidentServices = angular.module('incidentServices', ['ngResource']);

incidentServices.factory('Incident', ['$resource',
   function($resource){
	return $resource('http://localhost:8080/Inc1/rest/incidents/:incidetId', {}, {
		query: {method:'GET', params:{incidentId:'incidents'}, isArray:false}
	});
	
   }]);
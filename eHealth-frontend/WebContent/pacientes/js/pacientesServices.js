/**
 * 
 */

var pacientesService = angular.module('pacientes.services',['ngResource']);

pacientesService.factory('pacientesAll', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/pacientes/all', {}, {
		query:{ method:'GET', params:{}, isArray: true }
	})
});

pacientesService.factory('enfermedades', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/pacientes/enfermedades', {}, {
		query:{ method:'GET', params:{}, isArray: true }
	})
});

pacientesService.factory('pacienteId', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/pacientes/find/:id', {}, {
		show:{ method:'GET', params:{id: '@id'}}
	})
});

pacientesService.factory('pacienteReportes', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/reportes/Reportes-of/:id', {}, {
		show:{ method:'GET', params:{id: '@id'}}
	})
});

pacientesService.factory('pacienteNew', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/pacientes/new', {}, {
		create:{ method:'POST'}
	})
});

pacientesService.factory('reporteNew', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/reportes/new', {}, {
		create:{ method:'POST'}
	})
});

pacientesService.factory('pacienteUpdate', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/pacientes/modify/:id', {}, {
		update:{ method:'PUT', params:{id: '@id'}}
	})
});

pacientesService.factory('pacienteDelete', function($resource){
	return $resource('http://localhost:8080/Milagroso/eHealth/pacientes/remove/:id', {}, {
		delete:{ method:'DELETE', params:{id: '@id'}}
	})
});
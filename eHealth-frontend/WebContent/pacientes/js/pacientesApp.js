/**
 * 
 */

var pacientesApp = angular.module('pacientes',['ngRoute','pacientes.services','pacientes.controllers']);

pacientesApp.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/lista', {templateUrl: 'partials/lista.html', controller: 'pacientesList'});
	$routeProvider.when('/registro', {templateUrl: 'partials/nuevo.html', controller: 'pacientesRegistro'});
	$routeProvider.otherwise({redirectTo: '/lista'});
}]);
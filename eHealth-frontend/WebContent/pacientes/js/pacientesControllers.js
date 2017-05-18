/**
 * 
 */

var pacientesControllers = angular.module('pacientes.controllers',[]);

pacientesControllers.controller('pacientesList',['$scope','pacientesAll','$location', function($scope,pacientesAll,$location){
	$scope.pacientes = pacientesAll.query();
	
	$scope.crear = function(){
		$location.path('/registro');
	}
	
}]);

pacientesControllers.controller('pacientesRegistro',['$scope','enfermedades','pacienteNew','$location', function($scope,enfermedades,pacienteNew,$location){
	$scope.enfermedades = enfermedades.query();
	
	$scope.cancelar = function(){
		$location.path('/lista');
	}
	
	$scope.registrar = function(){
		pacienteNew.create($scope.paciente);
		$location.path('/lista');
	}
	
}]);
package org.zer0.pocs.retrofitdemo.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.retrofitdemo.data.Contrato;
import org.zer0.pocs.retrofitdemo.data.Empleado;
import org.zer0.pocs.retrofitdemo.service_retrofit.EmpleadoService;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
@RequestMapping("/retrofit")
public class EmpleadoRestController {

	private Retrofit conectar() {
		OkHttpClient.Builder httpCliente = new OkHttpClient.Builder();
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080/")
				.addConverterFactory(GsonConverterFactory.create()).client(httpCliente.build()).build();
		return retrofit;
	}

	@GetMapping("/operaciones")
	public String saludar() {
		Retrofit retrofit = conectar();

		EmpleadoService serviceEmpleado = retrofit.create(EmpleadoService.class);
		listarEmpleados(serviceEmpleado);
		guardarEmpleado(serviceEmpleado);
		listarEmpleados(serviceEmpleado);
		System.out.println("-------");
		getEmpleadosContratoMayorNMeses(serviceEmpleado);
		return "done!";
	}

	private void listarEmpleados(EmpleadoService serviceEmpleado) {
		Call<List<Empleado>> callSync = serviceEmpleado.getListaEmpleados();

		Response<List<Empleado>> response;
		try {
			response = callSync.execute();
			List<Empleado> empleados = response.body();
			empleados.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void guardarEmpleado(EmpleadoService serviceEmpleado) {
		Empleado empleado=new Empleado("42514140","Simon","Marticorena","Santos",30,"M",new Contrato(1500,"PRIMA",7));
		
		Call<ResponseBody> callSync = serviceEmpleado.registrarEmpleado(empleado);

		Response<ResponseBody> response;
		try {
			response = callSync.execute();
			System.out.println(response.message());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getEmpleadosContratoMayorNMeses(EmpleadoService serviceEmpleado) {
		Call<List<Empleado>> callSync = serviceEmpleado.getEmpleadosPorContratoMayorNMeses(8);

		Response<List<Empleado>> response;
		try {
			response = callSync.execute();
			List<Empleado> empleados = response.body();
			empleados.forEach(e->{
				System.out.println(e.getNombres());
				System.out.println(e.getApellidoPaterno());
				System.out.println(e.getApellidoMaterno());
				System.out.println(e.getContratoActual().getPeriodoEnMeses());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

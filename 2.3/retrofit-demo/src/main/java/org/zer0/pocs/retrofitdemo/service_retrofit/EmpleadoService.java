package org.zer0.pocs.retrofitdemo.service_retrofit;

import java.util.List;

import org.zer0.pocs.retrofitdemo.data.Empleado;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EmpleadoService {

	@GET("/empleados")
	public Call<List<Empleado>> getListaEmpleados();
	
	@POST("/empleados")
	public Call<ResponseBody> registrarEmpleado(@Body Empleado empleado);
	
	@GET("/empleados/contrato")
	public Call<List<Empleado>> getEmpleadosPorContratoMayorNMeses(@Query("nroMeses") int nroMeses);
	
}

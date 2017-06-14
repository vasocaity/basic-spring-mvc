import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {
	public ArrayList<Integer> findTem(String prov) throws IOException{
		OkHttpClient client = new OkHttpClient();
		String googleUrl = "http://data.tmd.go.th/api/WeatherForecast7Days/V1/?type=json";
		Request req = new Request.Builder().url(googleUrl).build();
		Response res = client.newCall(req).execute();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(res.body().string());
		List<Integer> maxTemp = JsonPath.read(document, "$.Provinces[?(@.ProvinceNameTh=='"+prov+"')].SevenDaysForecast[*].MaxTemperature.Value");
		for(int i=0; i<maxTemp.size(); i++) {
		maxTemp.get(i);
		//System.out.println(maxTemp.get(i));
		}
		return (ArrayList<Integer>) maxTemp;
	}
	public ArrayList<String> getProv() throws IOException{
		OkHttpClient client = new OkHttpClient();
		String googleUrl = "http://data.tmd.go.th/api/WeatherForecast7Days/V1/?type=json";
		Request req = new Request.Builder().url(googleUrl).build();
		Response res = client.newCall(req).execute();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(res.body().string());
		List<String> prov = JsonPath.read(document, "$.Provinces[*].ProvinceNameTh");
		for(int i=0; i<prov.size(); i++) {
			prov.get(i);
		//System.out.println(prov.get(i));
		}
		return (ArrayList<String>) prov;
	}	
}


package telran.imagga.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.dto.ResponseColorsDto;

public class ImaggaTagController {
	static final RestTemplate restTemplate = new RestTemplate();
	static final String TOKEN = "Basic YWNjX2RkMDY2YWRkOTFlODE2YTpiNjRjNmYzMGZiMDI5MjUyMDgyNWYxNzEwN2I0NzM4Mg==";
	static String img = "https://pbs.twimg.com/media/FfGT4b2WIAc2k5w?format=jpg&name=900x900";
	static String baseUrl = "https://api.imagga.com/v2/colors";

	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, TOKEN);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
									.queryParam("image_url", img);
		RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri());
		
		ResponseEntity<ResponseColorsDto> responseEntity = restTemplate.exchange(requestEntity, ResponseColorsDto.class);
		
		responseEntity.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
		System.out.println();
		responseEntity.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
		System.out.println();
		responseEntity.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);

		
	}

}

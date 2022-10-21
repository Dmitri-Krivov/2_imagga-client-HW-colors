package telran.imagga.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class ResultColorsDto {
	List<ColorsDto> background_colors;
	List<ColorsDto> foreground_colors;
	List<ColorsDto> image_colors;
}

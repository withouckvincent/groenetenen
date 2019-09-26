package be.vdab.groenetenen.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class VanTotPostcodeForm {
	@NotNull
	@Range(min = 1000, max = 9999)
	private final Integer van;

	@NotNull
	@Range(min = 1000, max = 9999)
	private final Integer tot;

	public VanTotPostcodeForm(@NotNull @Range(min = 1000, max = 9999) Integer van,
			@NotNull @Range(min = 1000, max = 9999) Integer tot) {
		super();
		this.van = van;
		this.tot = tot;
	}

	public Integer getVan() {
		return van;
	}

	public Integer getTot() {
		return tot;
	}

}

package org.openmap4j.output;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.output.Drawable;
import org.openmap4j.output.Paramatrizeable;
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.Symbolizeable;
import org.openmap4j.style.TextStyleable;

class DrawableTest {

	Drawable draw = null;

	@BeforeEach
	void beforeEach() {
		draw = new Drawable() {

			@Override
			public void accept(Styleable defaultStyle) {
				// TODO Auto-generated method stub

			}

			@Override
			public void accept(Symbolizeable... symbol) {
				// TODO Auto-generated method stub

			}

			@Override
			public void accept(Object symbol, double x, double y, Object... params) {
				// TODO Auto-generated method stub

			}

			@Override
			public Drawable draw(double x, double y, Object... otionalParams) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable draw(Shape line, Object... otionalParams) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable draw(Area area, Object... optionalParams) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void write(Writer out) throws IOException {
				// TODO Auto-generated method stub

			}

			@Override
			public Drawable style(Symbolizeable... symbols) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable style(AreaStyleable areaStyle) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable style(ImageStyleable imageStyle) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable style(LineStyleable lineStyle) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable style(TextStyleable textStyle) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable draw(Area area, double x, double y, Object... optionalParams) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable draw(Path image, double x, double y, Object... optionalParams) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable draw(Shape line, double x, double y, Object... optionalParams) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Drawable draw(String text, double x, double y, Object... optionalParams) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Test
	void testParseObjectArray_Null() {
		assertEquals(draw.parse(LineStyleable.class).isPresent(), false);
	}

	@Test
	void testParseObjectArray_AffineTransform() {
		Optional<Paramatrizeable<LineStyleable>> params = draw.parse(LineStyleable.class,
				new AffineTransform(1, 2, 3, 4, 5, 6));
		assertEquals(params.isPresent(), true);
		assertEquals(params.get().getTransform().isPresent(), true);
		assertEquals(params.get().getTransform().get(), new AffineTransform(1, 2, 3, 4, 5, 6));
	}

	enum StyleableParam {
		LINESTYLE(StyleBuilderFactory.getLineStyleBuilder().build()), AREASTYLE(
				StyleBuilderFactory.getAreaStyleBuilder().build()), TEXTSTYLE(
						StyleBuilderFactory.getTextStyleBuilder().build()), IMAGESTYLE(
								StyleBuilderFactory.getImageStyleBuilder().build());

		private Styleable style;

		private StyleableParam(Styleable style) {
			this.style = style;
		}

		Styleable getStyle() {
			return this.style;
		}

	}

	@DisplayName("Should set single style param")
	@ParameterizedTest
	@EnumSource(StyleableParam.class)
	void testParseObjectArray_StyleableParam(StyleableParam param) {
		Optional<?> params = draw.parse(param.getStyle().getClass(), param.getStyle());
		assertEquals(params.isPresent(), true);
		Paramatrizeable<Styleable> paramVal = (Paramatrizeable<Styleable>) params.get();
		assertEquals(paramVal.getTransform().isPresent(), false);
		assertEquals(paramVal.getStyle().isPresent(), true);
		assertEquals(paramVal.getStyle(), param.getStyle());
	}

}

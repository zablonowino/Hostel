package Hostel;

import java.awt.Color;
import java.util.Locale;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Templates {

    public static final StyleBuilder rootStyle;
    public static final StyleBuilder boldStyle,boldStyle1;
    public static final StyleBuilder italicStyle;
    public static final StyleBuilder boldLeftStyle,boldCenteredStyle,boldRightStyle;
    public static final StyleBuilder bold12CenteredStyle;
    public static final StyleBuilder bold14LeftStyle;
    public static final StyleBuilder bold14CenteredStyle;
    public static final StyleBuilder bold14RightStyle;
    public static final StyleBuilder bold16LeftStyle;
    public static final StyleBuilder bold16CenteredStyle;
    public static final StyleBuilder bold16RightStyle,bold16RightStyle1;
    public static final StyleBuilder bold20CenteredStyle;
    public static final StyleBuilder columnStyle;
    public static final StyleBuilder columnTitleStyle;
    public static final StyleBuilder groupStyle;
    public static final StyleBuilder subtotalStyle;
    public static final ReportTemplateBuilder reportTemplate;
    public static final CurrencyType currencyType;
    public static final ComponentBuilder<?, ?> dynamicReportsComponent;
    public static final ComponentBuilder<?, ?> footerComponent;

    static {
        rootStyle = stl.style().setPadding(2);
        boldStyle = stl.style(rootStyle).bold();
        boldStyle1 = stl.style(rootStyle);
        italicStyle = stl.style(rootStyle).italic();
        boldLeftStyle = stl.style(boldStyle1)
                .setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
        boldCenteredStyle = stl.style(boldStyle1)
                .setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
        boldRightStyle = stl.style(boldStyle1)
                .setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
        
        
        bold12CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(12);
        bold14LeftStyle = stl.style(boldLeftStyle)
                .setFontSize(14).setHorizontalAlignment(HorizontalAlignment.LEFT);
        bold14CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(14).setHorizontalAlignment(HorizontalAlignment.LEFT);
        bold14RightStyle = stl.style(boldRightStyle)
                .setFontSize(14).setHorizontalAlignment(HorizontalAlignment.LEFT);
        
        bold16LeftStyle = stl.style(boldLeftStyle)
                .setFontSize(10);
        bold16CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(10);
        bold16RightStyle = stl.style(boldRightStyle)
                .setFontSize(10);
        bold16RightStyle1 = stl.style(boldRightStyle)
                .setFontSize(20);
        bold20CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(20);
        columnStyle = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE);
        columnTitleStyle = stl.style(columnStyle)
                .setBorder(stl.pen1Point())
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setBackgroundColor(Color.LIGHT_GRAY)
                .bold();
        groupStyle = stl.style(boldStyle)
                .setHorizontalAlignment(HorizontalAlignment.LEFT);
        subtotalStyle = stl.style(boldStyle)
                .setTopBorder(stl.pen1Point());

        StyleBuilder crosstabGroupStyle = stl.style(columnTitleStyle);
        StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(170, 170, 170));
        StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(140, 140, 140));
        StyleBuilder crosstabCellStyle = stl.style(columnStyle)
                .setBorder(stl.pen1Point());

        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
                .setHeadingStyle(0, stl.style(rootStyle).bold());

        reportTemplate = template()
                .setLocale(Locale.ENGLISH)
                .setColumnStyle(columnStyle)
                .setColumnTitleStyle(columnTitleStyle)
                .setGroupStyle(groupStyle)
                .setGroupTitleStyle(groupStyle)
                .setSubtotalStyle(subtotalStyle)
                .highlightDetailEvenRows()
                .crosstabHighlightEvenRows()
                .setCrosstabGroupStyle(crosstabGroupStyle)
                .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
                .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
                .setCrosstabCellStyle(crosstabCellStyle)
                .setTableOfContentsCustomizer(tableOfContentsCustomizer);

        currencyType = new CurrencyType();

        HyperLinkBuilder link = hyperLink("");
        dynamicReportsComponent =
                
                cmp.horizontalList(
                cmp.image(Templates.class.getResource("apartments1.jpeg")).setFixedDimension(120, 80),
                cmp.verticalList(
                cmp.text("Apartment Manager").setStyle(bold20CenteredStyle).setHorizontalAlignment(HorizontalAlignment.LEFT),
                cmp.text("").setStyle(italicStyle).setHyperLink(link))).setFixedWidth(400);
        footerComponent = 
                cmp.horizontalList(
                cmp.text("")
                .setStyle(
                stl.style(boldCenteredStyle)
                .setTopBorder(stl.pen1Point())
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                ),
                cmp.pageXofY()
                .setStyle(
                stl.style(boldCenteredStyle)
                .setTopBorder(stl.pen1Point())
                .setHorizontalAlignment(HorizontalAlignment.RIGHT)));
    }

 

    /**
     * Creates custom component which is possible to add to any report band
     * component
     */
    public static ComponentBuilder<?, ?> createTitleComponent(String label) {
        return cmp.horizontalList()
                .add(
                dynamicReportsComponent,
                cmp.text(label).setStyle(bold12CenteredStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT))
                .newRow()
                .add(cmp.line())
                .newRow()
                .add(cmp.verticalGap(10));
    }

    public static ComponentBuilder<?, ?> createTitleComponent1
          (String label,String label1,String label2,String label3,String label4) {
		return cmp.horizontalList()
		        .add(
		         dynamicReportsComponent,
		         cmp.text(label).setStyle(bold16RightStyle1).
                         setHorizontalAlignment(HorizontalAlignment.RIGHT))
                        .newRow()
		        .add(cmp.line())
                        .newRow()
                        .add(cmp.text(label4).setStyle(bold16RightStyle1).
                        setHorizontalAlignment(HorizontalAlignment.CENTER))
		        .newRow()
                        .add(cmp.text(label1).setStyle(bold16LeftStyle).
                        setHorizontalAlignment(HorizontalAlignment.LEFT))
                        .add(cmp.text(label2).setStyle(bold16CenteredStyle).
                        setHorizontalAlignment(HorizontalAlignment.CENTER))
                        .add(cmp.text(label3).setStyle(bold16RightStyle).
                        setHorizontalAlignment(HorizontalAlignment.RIGHT))
		        .add(cmp.verticalGap(10));
	}
    public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
        return new CurrencyValueFormatter(label);
    }

    public static class CurrencyType extends BigDecimalType {

        private static final long serialVersionUID = 1L;

        @Override
        public String getPattern() {
            return "KShs #,###.00";
        }
    }

    private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {

        private static final long serialVersionUID = 1L;
        private String label;

        public CurrencyValueFormatter(String label) {
            this.label = label;
        }

        @Override
        public String format(Number value, ReportParameters reportParameters) {
            return label + currencyType.valueToString(value, reportParameters.getLocale());
        }
    }
}
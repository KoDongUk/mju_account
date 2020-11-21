package popupcontrollers;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

import database.user_account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class ConsumptionPatternController implements Initializable{
	int agoagoExp, agoExp, currentExp;
	int agoagoMonth, agoMonth, currentMonth;
	int agoagoSum, agoSum, currentSum;
	private Calendar calendar;//현재 날짜를 불러오기위한 용도.
	private user_account ua;
	
    @FXML private BarChart barChart;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		calendar = Calendar.getInstance();//달력객체의 인스턴스를 받아옴
		ua = new user_account();
		
		
		
		agoagoMonth = calendar.get(Calendar.MONTH)-1;//전전월
		agoMonth = calendar.get(Calendar.MONTH);//전월
		currentMonth = calendar.get(Calendar.MONTH)+1;//현월
		
		try {
			agoagoSum = ua.getMonthExpenditureSum(agoagoMonth);
			agoSum = ua.getMonthExpenditureSum(agoMonth);
			currentSum = ua.getMonthExpenditureSum(currentMonth);
			
			System.out.println(agoagoSum + agoSum + currentMonth);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		XYChart.Series agoago = new XYChart.Series();
		agoago.setName(Integer.toString(agoagoMonth)+ "월");       
		agoago.setData(FXCollections.observableArrayList(new XYChart.Data("", agoagoSum)));  

		XYChart.Series ago = new XYChart.Series();
		ago.setName(Integer.toString(agoMonth) + "월");       
		ago.setData(FXCollections.observableArrayList(new XYChart.Data("", agoSum)));
		
		XYChart.Series current = new XYChart.Series();
		current.setName(Integer.toString(currentMonth) + "월");       
		current.setData(FXCollections.observableArrayList(new XYChart.Data("", currentSum)));

		barChart.getData().add(agoago);
		barChart.getData().add(ago);
		barChart.getData().add(current);
	}
	
	
}

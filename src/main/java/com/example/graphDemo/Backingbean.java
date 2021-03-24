package com.example.graphDemo;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named("backingBean")
@RequestScoped
public class Backingbean {

    @Inject CoordinateEJB coordinateEJB;

    public LineChartModel getLineModel() {
        return lineModel;
    }

    private LineChartModel lineModel;



    @PostConstruct
    public void init() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = getYlist();
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);

        List<String> labels = getXlist();

        data.setLabels(labels);

        //Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        options.setTitle(title);

        lineModel.setOptions(options);
        lineModel.setData(data);

    }



    int y;

    public void refresh(){
        System.out.println("refreshing page");
    }

    public boolean CreatCoord(){

        System.out.println("we are creating a value of "+ y);

        return coordinateEJB.createCoordinate(y);
    }

    public void deleteCoords(){ coordinateEJB.deleteQuery();}

    public ArrayList<Coordinate> getPersonList(){
        return coordinateEJB.tableQuery();
    }

    public void Printlist(){
        List<String> x = getXlist();
        List<Object> y = getYlist();
        System.out.println("x , y");
        for(int i=0; i< x.size();i++){
            System.out.println(x.get(i)+" , "+y.get(i));
        }
    }


    // retreving a list of the X variables
    public ArrayList<String> getXlist(){
        ArrayList<Coordinate> coords = getPersonList();
        ArrayList<String> x_vals = new ArrayList<>();


        if (coords.size()==0){
            x_vals.add("0");
        }else {
            x_vals.add("0");
            for(int i=0; i< coords.size(); i++){
                String x = String.valueOf(coords.get(i).getX_value());
                x_vals.add(x);
                //System.out.println(x.get(i).getX_value()+ ", "+ x.get(i).getY_value());
            }
        }

        return x_vals;
    }

    public List<Object> getYlist(){
        ArrayList<Coordinate> coords = getPersonList();
        ArrayList<Number> y_vals = new ArrayList<>();
        List<Object> object = new ArrayList<Object>();

        if (coords.size()==0){
            y_vals.add(0);
        }else {
            y_vals.add(0);
            for(int i=0; i< coords.size(); i++){
                y_vals.add(coords.get(i).getY_value());
                //System.out.println(x.get(i).getX_value()+ ", "+ x.get(i).getY_value());
                object.add(coords.get(i).getY_value());
            }
        }
        return object;
    }



    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

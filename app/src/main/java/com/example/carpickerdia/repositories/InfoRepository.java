package com.example.carpickerdia.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.carpickerdia.db.CarResponse;
import com.example.carpickerdia.models.Car;
import com.example.carpickerdia.networking.CarApi;
import com.example.carpickerdia.networking.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoRepository {
    private static InfoRepository instance;
    private final MutableLiveData<String> randomBrand;
    private final MutableLiveData<List<Car>> randomCars;
    private final MutableLiveData<List<Car>> cheapestCars;
    private final MutableLiveData<List<Car>> reliableCars;
    private final MutableLiveData<List<Car>> expensiveCars;
    private final MutableLiveData<List<String>> allBrands;
    private final MutableLiveData<List<String>> allModels;
    private List<Car> cheapestCarList;
    private List<Car> reliableCarList;
    private List<Car> expensiveCarList;

    private InfoRepository() {
        randomBrand = new MutableLiveData<>();
        randomCars = new MutableLiveData<>();
        cheapestCars = new MutableLiveData<>();
        reliableCars = new MutableLiveData<>();
        expensiveCars = new MutableLiveData<>();
        allBrands = new MutableLiveData<>();
        allModels = new MutableLiveData<>();
    }

    public static synchronized InfoRepository getInstance() {
        if(instance == null) {
            instance = new InfoRepository();
        }
        return instance;
    }

    public LiveData<List<String>> getAllBrands() {
        return allBrands;
    }

    public LiveData<List<String>> getAllModels() {
        return allModels;
    }

    public LiveData<List<Car>> getCheapestCars() {
        return cheapestCars;
    }

    public LiveData<List<Car>> getReliableCars() {
        return reliableCars;
    }

    public LiveData<List<Car>> getExpensiveCars() {
        return expensiveCars;
    }

    public LiveData<List<Car>> getRandomCars() {
        return randomCars;
    }

    public LiveData<String> getRandomBrand() {
        return randomBrand;
    }

    public void generateRandomPick() {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>() {
            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if (response.isSuccessful()) {
                    List<CarResponse> carResponse = response.body();
                    Random random = new Random();
                    List<Car> temp = new ArrayList<>();
                    while(temp.size() < 4) {
                        boolean flag = false;
                        Car car = carResponse.get(random.nextInt(carResponse.size())).getCar();
                        for (Car car1 : temp) {
                            if (car1.getId() == car.getId()) {
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            temp.add(car);
                        }
                    }
                    randomCars.postValue(temp);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void generateCarsAccordingToBrand(String make){
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>() {
            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if (response.isSuccessful()) {
                    List<CarResponse> carResponse = response.body();
                    List<Car> carBrand = new ArrayList<>();
                    for(CarResponse car: carResponse){
                        if(make.equals(car.getCar().getMake())){
                            carBrand.add(car.getCar());
                        }

                    }
                    randomCars.postValue(carBrand);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void getAllCarBrands() {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>() {

            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if (response.isSuccessful()) {
                    List<CarResponse> carResponse = response.body();
                    List<String> brands = new ArrayList<>();

                    for(CarResponse car: carResponse) {
                        if(!brands.contains(car.getCar().getMake())) {
                            brands.add(car.getCar().getMake());
                        }
                    }
                    allBrands.setValue(brands);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void getAllCarModels(String make) {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>() {

            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if (response.isSuccessful()) {
                    List<CarResponse> carResponse = response.body();
                    List<String> models = new ArrayList<>();

                    for(CarResponse car: carResponse) {
                        if(make.equals(car.getCar().getMake())) {
                            models.add(car.getCar().getModel());
                        }
                    }  System.out.println("Car Model" + models.size());
                    allModels.setValue(models);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void generateRandomBrand() {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>() {
            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if (response.isSuccessful()) {
                    List<CarResponse> carResponse = response.body();
                    Random random = new Random();
                    Car car = carResponse.get(random.nextInt(carResponse.size())).getCar();
                    randomBrand.postValue(car.getMake());
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void findCheapestCars() {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>(){

            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if(response.isSuccessful()) {
                    cheapestCarList = new ArrayList<Car>();
                    List<CarResponse> carResponse = response.body();
                    for(CarResponse car: carResponse) {
                        if(car.getCar().getPrice() <= 30000) {
                            cheapestCarList.add(new Car(car.getCar().getMake(), car.getCar().getModel(),
                                    car.getCar().getYear(), car.getCar().getId(), car.getCar().getHorsepower(),
                                    car.getCar().getPrice(), car.getCar().getImg_url()));
                        }
                    }
                    cheapestCars.setValue(cheapestCarList);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void findExpensiveCars() {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>(){

            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if(response.isSuccessful()) {
                    expensiveCarList = new ArrayList<Car>();
                    List<CarResponse> carResponse = response.body();
                    for(CarResponse car: carResponse) {
                        if(car.getCar().getPrice() >= 80000) {
                            expensiveCarList.add(new Car(car.getCar().getMake(), car.getCar().getModel(),
                                    car.getCar().getYear(), car.getCar().getId(), car.getCar().getHorsepower(),
                                    car.getCar().getPrice(), car.getCar().getImg_url()));
                        }
                    }
                    expensiveCars.setValue(expensiveCarList);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }

    public void findReliableCars() {
        CarApi carApi = ServiceGenerator.getCarApi();
        Call<List<CarResponse>> call = carApi.getCar();
        call.enqueue(new Callback<List<CarResponse>>(){

            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if(response.isSuccessful()) {
                    reliableCarList = new ArrayList<Car>();
                    List<CarResponse> carResponse = response.body();
                    for(CarResponse car: carResponse) {
                        if(car.getCar().getPrice() < 80000 || car.getCar().getPrice() > 40000 ) {
                            reliableCarList.add(new Car(car.getCar().getMake(), car.getCar().getModel(),
                                    car.getCar().getYear(), car.getCar().getId(), car.getCar().getHorsepower(),
                                    car.getCar().getPrice(), car.getCar().getImg_url()));
                        }
                    }
                    reliableCars.setValue(reliableCarList);
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {

            }
        });
    }
}

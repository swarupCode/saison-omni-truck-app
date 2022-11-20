# saison-omni-truck-app
Food truck app that entails all the services related to that.


### Rest APIs:

1. Search by name of applicant [GET]
```sh
https://saison-food-truck-app.herokuapp.com/truck-app/Bonito%20Poke
```
![](../../../Pictures/Screenshots/Screenshot from 2022-11-21 00-00-20.png)

2. Search by expiration date, to find whose permits have expired [GET]

```sh
https://saison-food-truck-app.herokuapp.com/truck-app/date?expDate=2017-11-15T00:00
```
![](../../../Pictures/Screenshots/Screenshot from 2022-11-21 00-04-23.png)
3. Search by street name [GET]

```sh
https://saison-food-truck-app.herokuapp.com/truck-app/?streetName=MARKET%20ST:%20DRUMM%20ST%20intersection
```
![](../../../Pictures/Screenshots/Screenshot from 2022-11-21 00-06-40.png)
4. Add new food truck entry to the dataset [POST]

```sh
https://saison-food-truck-app.herokuapp.com/truck-app/addTruck
```
![](../../../Pictures/Screenshots/Screenshot from 2022-11-21 00-09-28.png)
5. Given a delivery location, find out the closest truck possible. [GET]

```sh
https://saison-food-truck-app.herokuapp.com/truck-app/distance?lat=37.786856111883054&lon=-122.40689189299718
```
![](../../../Pictures/Screenshots/Screenshot from 2022-11-21 00-08-03.png)


## Future Scopes

1. The logging needs to be improved.
2. There is no Exception Handling in the entire project which can be introduced. Global Level Exception can also be introduced.
3. Rest APIs should be improved, due to lack of time provided all types of inputs to showcase the knowledge. But its not apt.
4. Proper framework or Layered Architecture can be introduced to make the codebase more scalable.

Regards,
Swarup Das!
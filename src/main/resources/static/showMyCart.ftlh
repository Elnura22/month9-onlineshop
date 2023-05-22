<!DOCTYPE html>
<html>
<head>
    <title>Items list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</head>


<body>
<#include "navbar.ftlh">


<p>This is my cart</p>


<#list items as item>

    <div>
        <div class="card mb-3" style="max-width: 540px; display: flex; flex-wrap: wrap;  margin-left: 25px">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="images/${item.item.image}"  style="width:200px; height: 200px; padding-right: 20px" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <tr style="display: block">
                            <td><p>${item.item.name}</p></td>
                        </tr>
                        <tr>
                            <td><p>${item.item.description}</p></td>
                        </tr>
                        <tr>
                            <td><p>$${item.item.price}</p></td>
                        </tr>

                        <form action="/updateQuantity" method="post">
                            <input type="hidden" name="cartItemId" value="${item.id}">
                            <input type="number" name="quantity" value="${item.quantity}" min="1">
                            <button type="submit">Изменить количество</button>
                        </form>

                        <form action="/deleteItemFromCart" method="post">
                            <input type="hidden" name="itemId" value="${item.id}">
                            <button type="submit" class="btn btn-link text-danger">Удалить</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>



</#list>

<#--<form action="/goToOrderPage" method="get">-->
<#--    <button type="submit" style="color: rebeccapurple; margin-left: 350px">Оформить заказ</button>-->
<#--</form>-->

<a href="/startOrder">Оформить заказ</a>


</body>
</html>
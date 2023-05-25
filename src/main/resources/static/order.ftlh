<!DOCTYPE html>
<html>
<head>
    <title>Items list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
</head>


<body>
<#include "navbar.ftlh">

<form action="/makeOrder" method="post">
    <h2>Order details:</h2>

    <#--    <label for="name">Имя:</label>-->
    <#--    <input type="text" id="name" name="name" required>-->

    <#--    <label for="email">Email:</label>-->
    <#--    <input type="email" id="email" name="email" required>-->

    <label for="address">Address:</label>
    <textarea id="address" name="address" rows="3" required></textarea>

    <label for="address">Post index:</label>
    <input type="text" id="postIndex" name="postIndex" required>

    <#--    <label for="paymentMethod">Способ оплаты:</label>-->
    <#--    <select id="paymentMethod" name="paymentMethod" required>-->
    <#--        <option value="creditCard">Кредитная карта</option>-->
    <#--        <option value="paypal">PayPal</option>-->
    <#--        <option value="cash">Наличные</option>-->
    <#--    </select>-->

    <p>Total sum of order: $</p>

    <button type="submit">create order</button>
</form>


</body>
</html>
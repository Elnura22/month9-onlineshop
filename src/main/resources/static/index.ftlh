<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>


    <title>Document</title>
    <style>
        .popup {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            background-color: #f1f1f1;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            z-index: 9999;
        }
    </style>
</head>
<body>


<#include "navbar.ftlh">

<p>welcome to homePage</p>

<#--<#if _csrf??>-->
<#--    <form action="/logout" method="post">-->
<#--        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}" />-->
<#--        <button>Выйти</button>-->
<#--    </form>-->
<#--<#else>-->
<#--    <a href="/logout">Выйти</a>-->
<#--</#if>-->


<div class="allCards" style="display: flex; flex-wrap: wrap">
    <#list items.content as item>
        <div class="product-card" style="margin: 25px">
            <img src="images/${item.image}" style="width:200px; height: 200px" alt="Product Image"
                 class="product-image">
            <h3 class="product-title">${item.name}</h3>
            <p class="product-description">${item.description}</p>
            <p class="product-price">$${item.price}</p>

            <form action="/cart" method="post">
                <input type="hidden" name="itemId" value="${item.id}">
                <button class="add-to-cart-button" type="submit">Добавить в корзину</button>
            </form>


<#--             <#if orderedItems?seq_contains(item)>-->
<#--             <#if orderedItems ?size gt 0>-->
            <form action="/addReview" method="POST">
                <input type="hidden" name="itemId" value="${item.id}">
                <label for="text">Текст:</label><br>
                <textarea name="text" id="text" rows="1" cols="50"></textarea><br>
                <button type="submit">Отправить</button>
            </form>
<#--             </#if>-->
<#--             </#if>-->

            <#list items as item>
                <#if orderedItems?seq_contains(item.id)>
                    <form action="/addReview" method="POST">
                        <input type="hidden" name="itemId" value="${item.id}">
                        <label for="text">Текст:</label><br>
                        <textarea name="text" id="text" rows="1" cols="50"></textarea><br>
                        <button type="submit">Отправить</button>
                    </form>
                </#if>
            </#list>



            <div class="popup">

            <#if success?? >
                <div class="success-message" style="padding-left: 30px">
                    Отзыв успешно добавлен!
                </div>
            </#if>

            </div>
        </div>
    </#list>

</div>

<#if items.totalPages  gt 0>
    <div>
        <#list items.content as item>
            <#if items.hasPrevious()>
                <a href="?name=${item.name}&page=${items.number - 1}">Previous</a>
            </#if>

            <#if items.hasNext()>
                <a href="?name=${item.name}&page=${items.number + 1}">Next</a>
            </#if>
        </#list>

    </div>

</#if>


</body>
</html>
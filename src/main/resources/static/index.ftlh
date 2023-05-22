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
</head>
<body>
<#--<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #9ACD32;">-->
<#--    <div class="container-fluid" style="background-color: #9ACD32; padding-block: 10px; padding-inline: 50px" >-->
<#--        <a class="navbar-brand" href="#">Items</a>-->
<#--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">-->
<#--            <span class="navbar-toggler-icon"></span>-->
<#--        </button>-->
<#--        <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<#--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link active" aria-current="page" href="#">Profile</a>-->
<#--                </li>-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="#">Link</a>-->
<#--                </li>-->
<#--                <li class="nav-item dropdown">-->
<#--                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<#--                        Dropdown-->
<#--                    </a>-->
<#--                    <ul class="dropdown-menu">-->
<#--                        <li><a class="dropdown-item" href="#">Action</a></li>-->
<#--                        <li><a class="dropdown-item" href="#">Another action</a></li>-->
<#--                        <li><hr class="dropdown-divider"></li>-->
<#--                        <li><a class="dropdown-item" href="#">Something else here</a></li>-->
<#--                    </ul>-->
<#--                </li>-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link disabled">Disabled</a>-->
<#--                </li>-->
<#--            </ul>-->




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
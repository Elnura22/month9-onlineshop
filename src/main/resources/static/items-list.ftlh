<!DOCTYPE html>
<html>
<head>
    <title>Items list</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<#--    <script src="response.js"></script>-->


</head>
<body>
<form action="/items-list" method="get">
    <input id="input-find-by-name" type="text" name="name" placeholder="Введите текст для поиска">
    <input type="number" name="page" placeholder="Введите номер страницы">

    <button type="submit" id="searchBy">Поиск</button>
</form>

<div class="container flex flex-col align-center" id="resultNew">
    <h1>Item List</h1>
    <table>
        <thead>
        <th>Name</th>
        <th>Image</th>
        <th>Description</th>
        <th>Price</th>
        </thead>
        <tbody>
        <#list items.content as item>
            <tr>
                <td>${item.name}</td>
                <td><img src="images/${item.image}" style="width:200px; height: 200px"></td>
                <td>${item.description}</td>
                <td>${item.price}</td>
            </tr>
        </#list>
</div>

</tbody>
</table>


<#if items.totalPages gt 0>
    <div >
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
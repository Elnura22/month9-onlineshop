<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #9ACD32;">
    <div class="container-fluid" style="background-color: #9ACD32; padding-block: 10px; padding-inline: 50px" >
        <a class="navbar-brand" href="#">Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/items-list?name=t-shirt&page=0">Main Page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                        <form action="/logout" method="post">
<#--                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}" />-->
                            <button>Выйти</button>
                        </form>
                </li>
            </ul>


            <a style="margin-right: 10px; font-size: 20px; color: deeppink; " href="/myCart" class="bi bi-cart2 bi-animate"></a>


            <form class="d-flex" role="search" action="/items-list" method="get">
                <input class="form-control me-2" type="search"  name="name" placeholder="Search" aria-label="Search">
                <input type="number" name="page" placeholder="Введите номер страницы">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

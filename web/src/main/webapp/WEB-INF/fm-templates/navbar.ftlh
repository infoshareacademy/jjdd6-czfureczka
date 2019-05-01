<header>
    <nav class="navbar navbar-dark navbar-bg navbar-expand-md">
        <img class="navbar-brand d-inline-block align-bottom nav-image mr-0" src="/image/autobus.png" alt="Bus">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainmenu">

            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/menu">Start</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-expanded="false" id="submenu" aria-haspopup="true">Rozkład jazdy</a>

                    <div class="dropdown-menu" aria-labelledby="submenu">

                        <a class="dropdown-item" href="http://localhost:8080/stopTimes">Autobusy</a>
                        <a class="dropdown-item" href="http://localhost:8080/stopTimes">Tramwaje</a>

                    </div>

                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/stops">Najbliższy odjazd</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/transfer">Wyznaczanie trasy</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Losowa podróż</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/report">Raport</a>
                </li>

            </ul>

        </div>
    </nav>
</header>
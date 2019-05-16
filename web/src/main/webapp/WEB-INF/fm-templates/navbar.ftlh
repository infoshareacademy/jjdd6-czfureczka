<header>
    <nav class="navbar navbar-dark navbar-bg navbar-expand-md">
        <img class="navbar-brand d-inline-block align-bottom nav-image mr-0" src="/image/autobus.png" alt="Bus">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainmenu">

            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" href="/menu">Start</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/stopTimes">Rozkład jazdy</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/stops">Najbliższy odjazd</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/transfer">Wyznaczanie trasy</a>
                </li>

                <#if google_name??>
                <li class="nav-item">
                    <a class="nav-link" href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/logout">Wyloguj</a>
                </li>
                <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/googlelogin">Zaloguj</a>
                </li>
                </#if>

                <li class="nav-item">
                    <a class="nav-link" href="/report">Raport</a>
                </li>

            </ul>

        </div>
    </nav>
</header>
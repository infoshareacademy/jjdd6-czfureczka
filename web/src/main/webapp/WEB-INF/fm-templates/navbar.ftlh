<header>
    <nav class="navbar navbar-dark navbar-bg navbar-expand-md">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu"
                aria-controls="mainmenu" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainmenu">

            <ul class="navbar-nav mb-3 mx-auto" id="pills-tab" role="tablist">

                <li class="nav-item">

                    <a class="nav-link w3-hover-green" href="http://czfureczka.jjdd6.is-academy.pl/menu">Start</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link w3-hover-green" href="http://czfureczka.jjdd6.is-academy.pl/stopTimes">Rozkład
                        jazdy</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link w3-hover-green" href="http://czfureczka.jjdd6.is-academy.pl/stops">Najbliższy
                        odjazd</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link w3-hover-green" href="http://czfureczka.jjdd6.is-academy.pl/transfer">Wyznaczanie
                        trasy</a>
                </li>

                <#if google_name??>
                    <li class="nav-item">
                        <a class="nav-link w3-hover-green"
                           href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://czfureczka.jjdd6.is-academy.pl/logout">Wyloguj</a>
                    </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link w3-hover-green" href="http://czfureczka.jjdd6.is-academy.pl/googlelogin">Zaloguj</a>
                    </li>
                </#if>

                <#if administrator??>
                    <li class="nav-item">
                        <a class="nav-link w3-hover-green"
                           href="http://czfureczka.jjdd6.is-academy.pl/report">Raport</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link w3-hover-green" href="http://czfureczka.jjdd6.is-academy.pl/admin">Administratorzy</a>
                    </li>
                </#if>

            </ul>

        </div>
    </nav>
</header>
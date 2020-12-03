<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Jobs for Bid Page</title>
</head>
<body>


<!--     Customer Records Page    -->
<div class="jobsForBid">

    <!--      Navbar    -->
    <div class="nav">
        <div><strong>Home Design Solutions (HDS)</strong></div>

        <!--      Hyperlinks   -->
        <ul>
            <li><a href="../html-home/index.html">Home</a></li>
            <li><a href="../html-home/about.html">About</a></li>
            <li><a href="../html-home/contact.html">Contact</a></li>
        </ul>
    </div>

    <!--     Vertical DropDown Menu         -->
    <div id="divMenu">
        <ul>
            <li><a href="../html-home/about.html">About</a></li>

            <li><a href="../html-services/services.html">Services</a></li>

            <li><a href="#">Products</a>
                <ul>
                    <li><a href="../html-appliances/appliances.html">Appliances</a></li>
                    <li><a href="../html-appliances/cabinets.html">Cabinets</a></li>
                    <li><a href="../html-appliances/lighting.html">Lighting</a></li>
                    <li><a href="../html-appliances/plumbing.html">Plumbing</a></li>
                    <li><a href="../html-appliances/ct_ft.html">Countertops &
                        FloorTile</a></li>
                </ul>
            </li>

            <li><a href="#">Locations</a>
                <ul>
                    <li><a href="../html-locations/phoenix.html">Phoenix, AZ</a></li>
                    <li><a href="../html-locations/scottsdale.html">Scottsdale, AZ</a>
                    </li>
                    <li><a href="../html-locations/tucson.html">Tucson, AZ</a></li>
                    <li><a href="../html-locations/lv.html">Las Vegas, NV</a></li>
                    <li><a href="../html-locations/al.html">Albuquerque, NM</a></li>
                </ul>
            </li>

            <!--    Gallery Images      -->
            <li><a href="../html-gallery/gallery.html">Our Work</a></li>

            <li><a href="../employeeSection/employeeSection.html">Employee Log in</a>

            <li><a href="../html-faq/faq.html">FAQs</a>

        </ul>
    </div>

    <div class="jobsForBid-content">

        <h1>Jobs For Bid<br><br></h1>


        <table id="recordTable">
            <tr>
                <th>Job Bid ID</th>
                <th>Description</th>
                <th>Bid Amount</th>
                <th>Date Open</th>
                <th>Date Closed</th>
                <th></th>
            </tr>
            <tr>
                <td></td>
                <td><label><input type="text" name="new_description" value=""/></label>
                </td>
                <td><label><input type="text" name="new_bidAmount" value=""/></label></td>
                <td><label><input type="text" name="new_dateOpen" value=""/></label></td>
                <td><label><input type="text" name="new_dateClosed" value=""/></label>
                </td>
                <td>
                    <form action="../jobsForBidServlet" method="GET">
                        <input type="submit" name="Add New Job Bid"
                               value="Add New Job Bid">
                    </form>
                </td>
            </tr>
            <c:forEach var="bidList" items="${bidList}">
            <tr>
                <td>${bidList.job_bid_id}</td>
                <td>${bidList.description}</td>
                <td>${bidList.bid_amount}</td>
                <td>${bidList.date_open}</td>
                <td>${bidList.date_closed}</td>
                <td>
                    <form action="../jobsForBidServlet" method="POST">
                        <input type="hidden" name="id"
                               value="<c:out value='${bidList.job_bid_id}' />"/>
                        <input type="submit" name="Edit" value="Edit">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>



    </div>
</div>


<footer>
    <p><br><br><br></p>
    <h3>CONTACT US:<br><br></h3>
    <p>
        <strong>Home Design Solutions</strong> <br/>
        <strong>101 Sedalia Dr.</strong> <br/>
        <strong>Phoenix, AZ 85001</strong> <br/>
        Phone: 602-KITCHEN <br/>
        Fax: 602-555-1212
    </p>
</footer>


</body>
</html>



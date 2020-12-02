<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Employee Records Page</title>
</head>
<body>


<!-- Employee Records Page -->
<div class="employeeRecords">

    <!-- Navbar -->
    <div class="nav">
        <div><strong>Home Design Solutions (HDS)</strong></div>

        <!--      Hyperlinks   -->
        <ul>
            <li><a href="../html-home/index.html">Home</a></li>
            <li><a href="../html-home/about.html">About</a></li>
            <li><a href="../html-home/contact.html">Contact</a></li>
        </ul>
    </div>

    <!-- Vertical DropDown Menu -->
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

            <li><a href="../employeeSection/loginPage.html">Employee Log in</a>

            <li><a href="../html-faq/faq.html">FAQs</a>

        </ul>
    </div>

    <div class="employeeRecords-content">

        <h1>Employee Records<br><br></h1>


        <table id="recordTable">
            <tr>
                <th>Employee ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Middle Initial</th>
                <th>Position</th>
                <th>Pay Rate</th>
                <th>Office Location</th>
                <th>Site User ID</th>
                <th>Phone Number</th>
                <th>Office Extension</th>
                <th>Email</th>
                <th>Street Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Status</th>
                <th></th>
            </tr>
            <tr>
                <td>
                    <%--                    <label><input type="text" name="employeeId" value=""/></label>--%>
                </td>
                <form action="../employeeRecordsServlet" method="GET">
                    <td>
                        <label><input type="text" name="last_name" value=""/></label>
                    </td>
                    <td>
                        <label><input type="text" name="first_name" value=""/></label>
                    </td>
                    <td>
                        <label><input type="text" name="mi" value=""/></label>
                    </td>
                    <td>
                        <jsp:include
                                page="../templates/selectJobPosition.html"></jsp:include>
                    </td>
                    <td>
                        <jsp:include
                                page="../templates/selectPayRate.html"></jsp:include>
                    </td>
                    <td>
                        <jsp:include page="/templates/selectLocation.html"></jsp:include>
                    </td>
                    <td>
<%--                        <label><input type="text" name="site_user_id" value=""/></label>--%>
                    </td>
                    <td>
                        <label><input type="text" name="phone_num" value=""/></label>
                    </td>
                    <td>
                        <label><input type="text" name="office_extension" value=""/></label>
                    </td>
                    <td>
                        <label><input type="text" name="email" value=""/></label>
                    </td>
                    <td>
                        <label><input type="text" name="street" value=""/></label>
                    </td>
                    <td>
                        <label><input type="text" name="city" value=""/></label>
                    </td>
                    <td>
                        <jsp:include page="../templates/selectState.html"></jsp:include>
                    </td>
                    <td><label><input type="text" name="zip" value=""/></label>
                    </td>
                    <td>
                        <jsp:include page="../templates/selectStatus.html"></jsp:include>
                    </td>
                    <td>
                        <input type="submit" name="Add New Employee"
                               value="Add New Employee">
                    </td>
                </form>
            </tr>
            <c:forEach var="employeeList" items="${employeeList}">
                <tr>
                    <td>${employeeList.employee_id}</td>
                    <td>${employeeList.last_name}</td>
                    <td>${employeeList.first_name}</td>
                    <td>${employeeList.mi}</td>
                    <td>${employeeList.position}</td>
                    <td>${employeeList.payRate}</td>
                    <td>${employeeList.officeLocation}</td>
                    <td>${employeeList.site_user_id}</td>
                    <td>${employeeList.phone_num}</td>
                    <td>${employeeList.office_extension}</td>
                    <td>${employeeList.email}</td>
                    <td>${employeeList.street}</td>
                    <td>${employeeList.city}</td>
                    <td>${employeeList.state}</td>
                    <td>${employeeList.zip}</td>
                    <td>${employeeList.status_id}</td>
                    <td>
                        <form action="../employeeRecordsServlet" method="POST">
                            <input type="hidden" name="id"
                                   value="<c:out value='${employeeList.employee_id}' />"/>
                            <input type="submit" name="Edit" value="Edit">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <%--Sample layout--%>
            <tr>
                <td>{employeeList.employee_id}</td>
                <td>{employeeList.last_name}</td>
                <td>{employeeList.first_name}</td>
                <td>{employeeList.mi}</td>
                <td>{employeeList.position}</td>
                <td>{employeeList.payRate}</td>
                <td>{employeeList.officeLocation}</td>
                <td>{employeeList.site_user_id}</td>
                <td>{employeeList.phone_num}</td>
                <td>{employeeList.office_extension}</td>
                <td>{employeeList.email}</td>
                <td>{employeeList.street}</td>
                <td>{employeeList.city}</td>
                <td>{employeeList.state}</td>
                <td>{employeeList.zip}</td>
                <td>{employeeList.status_id}</td>
                <td>
                </td>
            </tr>
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


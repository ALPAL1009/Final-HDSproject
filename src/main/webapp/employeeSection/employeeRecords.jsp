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


<!--     Employee Records Page    -->
<div class="employeeRecords">

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

            <li><a href="../employeeSection/employeeSection.html">Employee</a>

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
                <th>Position</th>
                <th>Pay Rate</th>
                <th>Office Location</th>
                <th>Site User ID</th>
                <th>Street Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Status</th>
                <th> </th>
            </tr>
            <tr>
                <td><label><input type="text" name="employeeId" value=""/></label></td>
                <td><label><input type="text" name="emp.lastName" value=""/></label></td>
                <td><label><input type="text" name="emp.firstName" value=""/></label></td>
                <td><label><input type="text" name="emp.position" value=""/></label></td>
                <td><label><input type="text" name="emp.payRate" value=""/></label></td>
                <td>
                    <jsp:include page="/templates/selectLocation.html"></jsp:include>
                </td>
                <td><label><input type="text" name="emp.siteUserId" value=""/></label></td>
                <td><label><input type="text" name="emp.address" value=""/></label></td>
                <td><label><input type="text" name="emp.city" value=""/></label></td>
                <td>
                    <jsp:include page="../templates/selectState.html"></jsp:include>
                </td>
                <td><label><input type="text" name="emp.zip" value=""/></label></td>
                <td>
                    <jsp:include page="../templates/selectStatus.html"></jsp:include>
                </td>
                <td>
                    <form action="../employeeRecordsServlet" method="GET">
                        <input type="submit" name="Add New Employee" value="Add New Employee">
                    </form>
                </td>
            </tr>
            <c:forEach var="employeeList" items="${employeeList}">
                <tr>
                    <td>${employeeList.employeeId}</td>
                    <td>${employeeList.employeeLastName}</td>
                    <td>${employeeList.employeeFirstName}</td>
                    <td>${employeeList.position}</td>
                    <td>${employeeList.payRate}</td>
                    <td>${employeeList.officeLocation}</td>
                    <td>${employeeList.siteUserId}</td>
                    <td>${employeeList.streetAddress}</td>
                    <td>${employeeList.city}</td>
                    <td>${employeeList.state}</td>
                    <td>${employeeList.zip}</td>
                    <td>${employeeList.status}</td>
                    <td>
                        <a href="edit?id=<c:out value='${employeeList.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${employeeList.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <%--Sample layout--%>
            <tr>
                <td>{employeeList.employeeId}</td>
                <td>{employeeList.employeeFirstName}</td>
                <td>{employeeList.employeeLastName}</td>
                <td>{employeeList.position}</td>
                <td>{employeeList.payRate}</td>
                <td>{employeeList.officeLocation}</td>
                <td>{employeeList.siteUserId}</td>
                <td>{employeeList.streetAddress}</td>
                <td>{employeeList.city}</td>
                <td>{employeeList.state}</td>
                <td>{employeeList.zip}</td>
                <td>{employeeList.status}</td>
                <td>
                    <a href="edit?id=<c:out value='${employeeList.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${employeeList.id}' />">Delete</a>
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


<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=5,IE=9" ><![endif]-->
<!DOCTYPE html>
<html>
<head>
<title>Untitled Diagram</title>
<meta charset="utf-8"/>
</head>
<body>
<p># estock-market</p>

<p>Intsructions to run Project:</p>

<p>1. Clone Project.<br>
2. Build estock-market using mvn clean install.<br>
3. Start docker containers required for running application. Do docker-compose up.<br>
4. Start comapany-command, company-query applications.<br>
5. Start keycloak container with below command:<br>
 docker run -p 8080:8080 --name keycloak --hostname keycloak --network backup_default -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -e DB_VENDOR=MYSQL -e MYSQL_ADDR=mysql-container -e DB_DATABASE=keycloak -e DB_USER=root -e DB_PASSWORD=estockMarketRootPw quay.io/keycloak/keycloak:18.0.0 start-dev<br>
6. Import realms setting available in git repository.<br>
7. Get Access token using postman request available in git repository.<br>
8. Use Postman collection to test other services.</p>

<div class="mxgraph" style="max-width:100%;border:1px solid transparent;" data-mxgraph="{&quot;highlight&quot;:&quot;#0000ff&quot;,&quot;nav&quot;:true,&quot;resize&quot;:true,&quot;toolbar&quot;:&quot;zoom layers tags lightbox&quot;,&quot;edit&quot;:&quot;_blank&quot;,&quot;xml&quot;:&quot;&lt;mxfile host=\&quot;app.diagrams.net\&quot; modified=\&quot;2022-08-22T13:55:11.550Z\&quot; agent=\&quot;5.0 (Windows)\&quot; etag=\&quot;DKT-Vyv8o8DZ48STLEbP\&quot; version=\&quot;20.2.6\&quot; type=\&quot;google\&quot;&gt;&lt;diagram id=\&quot;KVKLBp9S7ODcK1OF-kKP\&quot; name=\&quot;Page-1\&quot;&gt;7VrbcpswEP0aP6YDCDA8pnbazrSdtPV0WvdNARXUYESFfOvXV5g7wsFhwLLTviRodTHaPXt2tWICZqvdWwoj/yNxUTDRFHc3AfOJplmazf8mgn0q0G0rFXgUu6lILQUL/AdlQiWTrrGL4tpARkjAcFQXOiQMkcNqMkgp2daH/SRB/Vcj6CFBsHBgIEq/YZf5mVQ17bLjHcKez/INm2nHCuaDs53EPnTJtiICdxMwo4Sw9Gm1m6Eg0V2ul3TemyO9xYtRFLJTJiy9x69WvPyFTP3+xv8zu7d/zG6yVTYwWGcbnmhmwNd77eINf/SSR4esIhjub/j/FQzdfAT/qcqglnm3URRgBzJMwrz3gTbHN1c5qIrtc/1Tsg5dlGxB4d1bHzO0iKCT9G454LjMZ6uAt9Ri9gZRhnZHtaQWuueYRWSFGN3zIdkEzcjMleG1MN+2Yv1c5lcMb2YymAHOK5YubcIfMrM8w0TaKSa62/D9LRih6GTrfCShR/jC89dXYxxdvzTj6C3GaSgJhe5tQkS85QQwjrHDlREzSJkorqirrlu0w+x71pM8LxP5KyNrzXeVYfN93gj5Dr9XG5VZSbOcdmjl89IdIFcgxoaZ+C7Jmjqom174Zj3EujAumr1iVqPFqrmMooCTzKb+um2mzn7hE8F8IyWq7DqqgN5AS7rNbFaVYRsLGU142o2FUj0ICx2QV2y7PxgNAYzv4c9HKCCSR6IoeXT2AeYYo6DbeR9SNH54KATQefQOGL1fM74MyuRxGsFV4wBhlpI/mNvKQPRsG3UVTw2BAUALVFR1LAYwezJAp6uX7r2sOP6wrn5ofUIUc10gKs//jf/+P4D/T5+TzP1eo0Qp/1Aqp6tAcrZgDc4Vhd+Xrr6sefoRv++TTvDGiFRhnEgVU5lUAYBVh5QyEFWA6XmpIg+HT3PFFwTd2gmh+1CxX3z+0JshzpWYDEAuzaChKyK5mC1AtMbiFrXtKD/KUeRCc43piQSiKu2GlZNs6Nq1MohYl7hdcwVqygJR7lpPhH9VSvgvjgDSwr8qVgveQoa2cC89V2qCSZGuq7Zk9jidhSQh+uOkdSrPyKKFopKVGwD0pIXmQmrzMDM2Ldg9w1B3vFHHKmN1hwz9RWBDCBnNosjI2NDaks6Bzj/ysKFdEjYEd78abICXiI1Lgkax7tVB43mXLC8tFdD7unRn3BjbbuJ9xEgurRvWuIfPy65KDYaYvp7OTZicYYphUTIgfuKF9fYXLgGYrjgsHJ93ouh9U1MUTqVVUaVVR60GfPri0FQkM5dYqA+IFzMY+wJkrqhm2VRrcT8lq2apiYfF9/gBhuKVtey7I0N68Qhogq7uOEUx7CwQpI4IzHPX2wzz4lR2tq9zjlzDqX2ykkpUscClxJUcfd1f8liXFIF6V9d10IhAZ66ug76589luc3rcIA+IxzxydOIRSC3PXAEeebP8BjkdXn7IDe7+Ag==&lt;/diagram&gt;&lt;/mxfile&gt;&quot;}"></div>
<script type="text/javascript" src="https://viewer.diagrams.net/js/viewer-static.min.js"></script>
</body>
</html>

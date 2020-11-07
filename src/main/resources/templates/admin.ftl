<head>
    <script src="https://www.gstatic.com/charts/loader.js"></script>
    <script>
        const chart = () => {
            const data = new google.visualization.DataTable();
            data.addColumn('string', 'Preguntas');
            data.addColumn('number', 'Votos');
            data.addRows([
                ['Las charlas donde usted participó cumplieron con sus expectativas?', ${first}],
                ['Los expositores mostraron tener dominio del tema?', ${second}],
                ['Las instalaciones del evento fueron comfortables para usted?', ${third}]
            ]);
            const options = {'title': 'Resultados', 'width': 1280, 'height': 720};
            const chart = new google.visualization.ColumnChart(document.getElementById('chart'));
            chart.draw(data, options);
        }

        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(chart);
    </script>
</head>
<body>
<div style="display: flex; justify-content: center; flex-direction: column">
    <h1 style="margin: 100px 0 0 150px; font-family: sans-serif;">Graficas para administradores</h1>
    <div id="chart"></div>
</div>

</body>
document.addEventListener("DOMContentLoaded", function () {
    var ctx = document.getElementById("productChart").getContext("2d");
    var barChart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: ["2월", "3월", "4월", "5월", "6월"],
        datasets: [
          {
            label: "매출",
            data: [1500, 1000, 2500, 1800, 2000],
            backgroundColor: [
              "rgba(54, 162, 235, 1)",
            ],
            borderColor: [
              "rgba(54, 162, 235, 1)",
            ],
            borderWidth: 1,
          },
          {
            label: "순이익",
            data: [800, 600, 1200, 1000, 900],
            backgroundColor: [
              "rgba(255, 159, 64, 1)",
            ],
            borderColor: [
              "rgba(255, 159, 64, 1)",
            ],
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    });
  });
  
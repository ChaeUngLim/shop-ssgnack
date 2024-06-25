document.addEventListener("DOMContentLoaded", function () {
    var ctx = document.getElementById("brandChart").getContext("2d");
    var barChart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: ["상품A", "상품B", "상품C", "상품D", "상품E"],
        datasets: [
          {
            label: "매출",
            data: [1500, 1000, 200, 1800, 2000],
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
  
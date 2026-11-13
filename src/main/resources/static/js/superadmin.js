/**
 * MediOne Super Admin Dashboard - Interactive Suite
 */

document.addEventListener('DOMContentLoaded', function () {
    // 1. Mobile Sidebar Toggle
    const mobileToggle = document.getElementById('sidebarToggleBtn');
    const sidebar = document.querySelector('.admin-sidebar');
    if (mobileToggle && sidebar) {
        mobileToggle.addEventListener('click', function () {
            sidebar.classList.toggle('sidebar-open');
        });

        // Close sidebar if clicking outside on mobile
        document.addEventListener('click', function (e) {
            if (window.innerWidth < 992) {
                if (!sidebar.contains(e.target) && !mobileToggle.contains(e.target)) {
                    sidebar.classList.remove('sidebar-open');
                }
            }
        });
    }

    // 2. Global / Instant Table Filtering
    const searchInputs = document.querySelectorAll('[data-sa-table-filter]');
    searchInputs.forEach(input => {
        const tableId = input.getAttribute('data-sa-table-filter');
        const table = document.getElementById(tableId);
        if (table) {
            input.addEventListener('input', function () {
                const query = this.value.toLowerCase().trim();
                const rows = table.querySelectorAll('tbody tr');
                rows.forEach(row => {
                    const text = row.textContent.toLowerCase();
                    row.style.display = text.includes(query) ? '' : 'none';
                });
            });
        }
    });

    // 3. Initialize Charts if canvas elements exist
    initDashboardCharts();
});

function initDashboardCharts() {
    // admissionsChart
    const admissionsCtx = document.getElementById('admissionsChart');
    if (admissionsCtx && window.Chart) {
        new Chart(admissionsCtx, {
            type: 'line',
            data: {
                labels: ['Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov'],
                datasets: [
                    {
                        label: 'Outpatients (OPD)',
                        data: [920, 1050, 1140, 1090, 1280, 1390],
                        borderColor: '#0284c7',
                        backgroundColor: 'rgba(2, 132, 199, 0.08)',
                        tension: 0.4,
                        fill: true,
                        pointBackgroundColor: '#0284c7',
                        pointBorderColor: '#ffffff',
                        pointBorderWidth: 2,
                        pointRadius: 4,
                        pointHoverRadius: 6
                    },
                    {
                        label: 'Inpatient Admissions',
                        data: [380, 420, 450, 410, 490, 530],
                        borderColor: '#10b981',
                        backgroundColor: 'rgba(16, 185, 129, 0.08)',
                        tension: 0.4,
                        fill: true,
                        pointBackgroundColor: '#10b981',
                        pointBorderColor: '#ffffff',
                        pointBorderWidth: 2,
                        pointRadius: 4,
                        pointHoverRadius: 6
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'top',
                        labels: {
                            usePointStyle: true,
                            boxWidth: 8,
                            font: { family: "'Plus Jakarta Sans', sans-serif", size: 12, weight: 600 },
                            color: '#475569'
                        }
                    },
                    tooltip: {
                        backgroundColor: '#0f172a',
                        titleFont: { size: 13, weight: 700 },
                        bodyFont: { size: 12 },
                        padding: 10,
                        cornerRadius: 8
                    }
                },
                scales: {
                    x: {
                        grid: { display: false },
                        ticks: { color: '#64748b', font: { size: 12, weight: 600 } }
                    },
                    y: {
                        grid: { color: '#f1f5f9' },
                        ticks: { color: '#64748b', font: { size: 12 } }
                    }
                }
            }
        });
    }

    // departmentChart
    const deptCtx = document.getElementById('departmentWorkloadChart');
    if (deptCtx && window.Chart) {
        new Chart(deptCtx, {
            type: 'doughnut',
            data: {
                labels: ['Cardiology', 'Emergency', 'Pediatrics', 'Orthopedics', 'Neurology', 'Oncology'],
                datasets: [{
                    data: [320, 380, 290, 240, 210, 180],
                    backgroundColor: [
                        '#0284c7', // Primary Sky
                        '#ef4444', // Danger Red
                        '#06b6d4', // Cyan
                        '#10b981', // Emerald
                        '#8b5cf6', // Purple
                        '#f59e0b'  // Amber
                    ],
                    borderWidth: 2,
                    borderColor: '#ffffff',
                    hoverOffset: 4
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                cutout: '72%',
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: {
                            usePointStyle: true,
                            boxWidth: 8,
                            font: { family: "'Plus Jakarta Sans', sans-serif", size: 11.5, weight: 600 },
                            color: '#475569',
                            padding: 14
                        }
                    }
                }
            }
        });
    }

    // revenueBreakdownChart
    const revCtx = document.getElementById('revenueBreakdownChart');
    if (revCtx && window.Chart) {
        new Chart(revCtx, {
            type: 'bar',
            data: {
                labels: ['Inpatient/ICU', 'Surgical OT', 'OPD Care', 'Diagnostic Lab', 'Pharmacy'],
                datasets: [{
                    label: 'Revenue ($)',
                    data: [165000, 95000, 48000, 42000, 34920],
                    backgroundColor: [
                        'rgba(2, 132, 199, 0.85)',
                        'rgba(13, 148, 136, 0.85)',
                        'rgba(59, 130, 246, 0.85)',
                        'rgba(139, 92, 246, 0.85)',
                        'rgba(245, 158, 11, 0.85)'
                    ],
                    borderRadius: 8
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { display: false }
                },
                scales: {
                    x: {
                        grid: { display: false },
                        ticks: { color: '#64748b', font: { size: 11.5, weight: 600 } }
                    },
                    y: {
                        grid: { color: '#f1f5f9' },
                        ticks: {
                            color: '#64748b',
                            callback: function(val) { return '$' + (val / 1000) + 'k'; }
                        }
                    }
                }
            }
        });
    }
}

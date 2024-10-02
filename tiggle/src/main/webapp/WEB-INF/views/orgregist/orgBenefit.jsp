<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 전시/박람회 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        .text-area-space {
            width: 100%;
            height: 200px;
            border: 2px solid #007BFF;
            margin-bottom: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .text-area-space p {
            color: #666;
            font-size: 16px;
        }
        .buttons {
            text-align: right;
            margin-top: 20px;
        }
        .btn {
            padding: 10px 20px;
            margin-left: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .cancel-btn {
            background-color: #d9534f;
        }
        .cancel-btn:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- A: 표 -->
    <table>
        <tr>
            <th>일반관리</th>
            <th>애로사항 및 정책지원</th>
            <th>홍보 및 소통</th>
            <th>교육 및 정보제공</th>
        </tr>
        <tr>
            <td>
                - 무료 발표지원 서비스<br>
                - 검토자 지원<br>
                - 진행과 관련된 다이어리 제공
            </td>
            <td>
                - 회원사 애로상담센터 운영
            </td>
            <td>
                - 소셜 알림 및 배너 광고<br>
                - 카카오톡 공식채널 내 전시회 홍보<br>
                - 홈페이지 내 전시회 및 회원사 소식
            </td>
            <td>
                - 전시주최사 교육(CEM) 등 교육 제공<br>
                - 최우수 기업 부여<br>
                - 국내외 전시산업 통계 보고서
            </td>
        </tr>
    </table>

    <!-- B: 텍스트 공간 -->
    <div class="text-area-space">
        <p>내용이 들어갈 공간입니다.</p>
    </div>

    <!-- C: 버튼 영역 -->
    <div class="buttons">
        <button class="btn">수정하기</button>
        <button class="btn cancel-btn" onclick="window.location.href='cancelPage.jsp';">취소/돌아가기</button>
    </div>
</div>

</body>
</html>

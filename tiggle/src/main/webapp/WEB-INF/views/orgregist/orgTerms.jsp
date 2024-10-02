<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 전시/박람회 편집</title>
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
        .info-box {
            border: 2px solid #007BFF;
            padding: 20px;
            background-color: #f9f9f9;
            margin-bottom: 20px;
        }
        .info-box p {
            margin: 0;
            font-size: 14px;
            color: #333;
        }
        .text-area-space {
            width: 100%;
            height: 200px;
            border: 1px solid #ccc;
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
    <!-- A: 정보 박스 -->
    <div class="info-box">
        <p><strong>제16조 청렴계약 이행</strong><br>
        주최자인 전시자는 본 계약과 관련하여 절대나 금품 등 일체의 부적절한 공여를 직/간접적으로 요구하거나 제공해서는 아니 되며, 깨끗하고 투명한 거래풍토조성 및 공정거래질서 유지를 위해 성실 노력한다. 위 참가규정 및 계약 조건을 모두 위임하였으며 이에 동의합니다.</p>
    </div>

    <!-- B: 텍스트 공간 -->
    <div class="text-area-space">
        <p>내용이 들어갈 공간입니다.</p>
    </div>

    <!-- C: 버튼 영역 -->
    <div class="buttons">
        <button class="btn">편집완료</button>
        <button class="btn cancel-btn" onclick="window.location.href='cancelPage.jsp';">취소/돌아가기</button>
    </div>
</div>

</body>
</html>

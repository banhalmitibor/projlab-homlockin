import os

tests = [
    # 1. Hányófej működése
    {
        "palya": "a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - e : jeg3t\ne U - : zuzalek\n",
        "input": "init test1_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 hanyo\nswap hk1 hanyo\nroute hk1 b c d e\nstep\nstep\nstep\nstep\nsave test1_expected.txt\n",
        "expected": "tj1 850 hk1\n\thk1 hanyo 0 0 0\na - :\nb - :\nc - : jeg3\nd - :\ne hk1 :\n"
    },
    # 2. Söprőfej működése
    {
        "palya": "a U - b :\nb U bb c : ho3\nc U cc d : jeg3\nd U dd e : jeg3t\ne U ee f : zuzalek\nf U - : ho5\nbb U - :\ncc U - :\ndd U - :\nee U - :\n",
        "input": "init test2_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nroute hk1 b c d e f\nstep\nstep\nstep\nstep\nstep\nsave test2_expected.txt\n",
        "expected": "tj1 925 hk1\n\thk1 sopro 0 0 0\na - :\nb - :\nc - : jeg3\nd - :\ne - : \naa - : \nbb - : ho3\ncc - :\ndd - : jeg3t\nee - : zuzalek\nf hk1 :\n"
    },
    # 3. Jégtörőfej működése
    {
        "palya": "a U - b :\nb U - : jeg3\n",
        "input": "init test3_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 jegtoro\nswap hk1 jegtoro\nroute hk1 b\nstep\nsave test3_expected.txt\n",
        "expected": "tj1 855 hk1\n\thk1 jegtoro 0 0 0\na - :\nb hk1 : jeg3t\n"
    },
    # 4. Sárkányfej működése
    {
        "palya": "a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - e : jeg3t\ne U - : zuzalek\n",
        "input": "init test4_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 sarkany\nswap hk1 sarkany\nbuy -kerozin hk1\nroute hk1 b c d e\nstep\nstep\nstep\nstep\nsave test4_expected.txt\n",
        "expected": "tj1 860 hk1\n\thk1 sarkany 0 26 0\na - :\nb - :\nc - :\nd - :\ne hk1 : zuzalek\n"
    },
    # 5. Zúzalékfej működése
    {
        "palya": "a U - b :\nb U - c : jeg3\nc U - : ho2\n",
        "input": "init test5_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 zuzalek\nswap hk1 zuzalek\nbuy -zuzalek hk1\nroute hk1 b c\nstep\nstep\nsave test5_expected.txt\n",
        "expected": "tj1 850 hk1\n\thk1 zuzalek 0 0 28\na - :\nb - : jeg3 zuzalek\nc hk1 : ho2 zuzalek\n"
    },
    # 6. Sószórófej működése
    {
        "palya": "a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - e : jeg3t\ne U - : zuzalek\n",
        "input": "init test6_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 soszoro\nswap hk1 soszoro\nbuy -so hk1\nroute hk1 b c d e\nstep\nstep\nstep\nstep\nsave test6_expected.txt\n",
        "expected": "tj1 860 hk1\n\thk1 soszoro 26 0 0\na - :\nb - : ho1\nc - : jeg2\nd - : jeg3t\ne hk1 : zuzalek\n"
    },
    # 7. Hóesés útszakaszon
    {
        "palya": "a U - : \n",
        "input": "init test7_palya.txt\nsnow\nsave test7_expected.txt\n",
        "expected": "a - : ho1\n"
    },
    # 8. Hóesés alagútban
    {
        "palya": "a A - :\nb U - : ho3\nc U - : jeg3\nd U - : jeg3t\n",
        "input": "init test8_palya.txt\nsnow\nsnow\nsnow\nsnow\nsave test8_expected.txt\n",
        "expected": "a - :\nb - : ho5\nc - : ho4 jeg3\nd - : ho4 jeg3t\n"
    },
    # 9. Zúzalék betemetése
    {
        "palya": "a U - : ho2 zuzalek\n",
        "input": "init test9_palya.txt\nsnow\nsnow\nsave test9_expected.txt\n",
        "expected": "a - : ho4\n"
    },
    # 10. Hó letaposása autó által
    {
        "palya": "a U - b :\nb U - c : ho3\nc U - : ho1 jeg1\n",
        "input": "init test10_palya.txt\ncar car1 a b c\nstep\nstep\nsave test10_expected.txt\n",
        "expected": "a - :\nb - : ho2 jeg1\nc car1 : jeg2\n"
    },
    # 11. Buszvezető játékos pontszerzése
    {
        "palya": "a U - b :\nb U - c :\nc U - d :\nd U - :\n",
        "input": "init test11_palya.txt\nadd -bj bj1 a d\nroute bj1 b c d\nstep\nstep\nstep\nsave test11_expected.txt\n",
        "expected": "bj1 5\na - :\nb - :\nc - :\nd bj1 :\n"
    },
    # 12. Takarító játékos pénzszerzése
    {
        "palya": "a U - b :\nb U - c : ho3\nc U - d : jeg3\nd U - : jeg3t\n",
        "input": "init test12_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nroute hk1 b c d\nstep\nstep\nstep\nstep\nsave test12_expected.txt\n",
        "expected": "tj1 915 hk1\n\thk1 sopro 0 0 0\na - :\nb - :\nc - : jeg3\nd hk1 :\n"
    },
    # 13. Autó elakadása
    {
        "palya": "a U - b :\nb U - c :\nc U - : ho4\n",
        "input": "init test13_palya.txt\ncar car1 a b c\nstep\nstep\nstep\nsave test13_expected.txt\n",
        "expected": "a - :\nb car1 :\nc - : ho4\n"
    },
    # 14. Autó elakadása és újraindulása
    {
        "palya": "a U - b :\nb U - c : ho5\nc U - :\nd U - b :\n",
        "input": "init test14_palya.txt\ncar car1 a b c\nadd -tj tj1\nstep\nstep\nstep\nbuy -hk hk1 tj1 d\nroute hk1 b c\nstep\nstep\nsave test14_expected.txt\n",
        "expected": "tj1 910 hk1\n\thk1 sopro 0 0 0\na - :\nb car1 : ho5\nc hk1 :\nd - :\n"
    },
    # 15. Autó célbaérkezése
    {
        "palya": "a U - b :\nb U - c :\nc U - :\n",
        "input": "init test15_palya.txt\ncar car1 a b c\nstep\nstep\nsave test15_expected.txt\n",
        "expected": "a - :\nb - :\nc - :\n"
    },
    # 16. Autó megcsúszás ütközés nélkül
    {
        "palya": "a U - b :\nb U - c : jeg4\nc U - :\n",
        "input": "init test16_palya.txt\ncar car1 a b c\nstep\nsave test16_expected.txt\n",
        "expected": "a - :\nb - : jeg4\nc car1 :\n"
    },
    # 17. Autó megcsúszás ütközéssel
    {
        "palya": "a U - b :\nb U - c : jeg4\nc U - e :\nd U - c :\ne U - :\n",
        "input": "init test17_palya.txt\ncar car1 d c e\ncar car2 a b c e\nstep\nstep\nsave test17_expected.txt\n",
        "expected": "a - :\nb car1 : jeg4\nc car2 :\nd - :\ne - :\n"
    },
    # 18. Autó megcsúszás ütközéssel letaposás miatt
    {
        "palya": "a U - b :\nb U - c :\nc U - d : ho1 jeg2\nd U - e :\ne U - :\n",
        "input": "init test18_palya.txt\ncar car1 b c d e\ncar car2 a b c d e\nstep\nstep\nstep\nsave test18_expected.txt\n",
        "expected": "a - :\nb - :\nc car2 : jeg3\nd car1 :\ne - :\n"
    },
    # 19. Busz ütközése
    {
        "palya": "a U - b :\nb U - c : jeg4\nc U - e :\nd U - c :\ne U - :\n",
        "input": "init test19_palya.txt\nadd -bj bj1 d a\nroute bj1 c e\ncar car1 a b c\nstep\nstep\nstep\nstep\nstep\nsave test19_expected.txt\n",
        "expected": "bj1 0\na - :\nb car1 : jeg4\nc - :\nd - :\ne bj1 :\n"
    },
    # 20. Hókotró ütközése
    {
        "palya": "a U - b :\nb U - c : jeg4\nc U - e :\nd U - c :\ne U - :\n",
        "input": "init test20_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 d\nroute hk1 c e\ncar car1 a b c\nstep\nstep\nsave test20_expected.txt\n",
        "expected": "tj1 900 hk1\n\thk1 sopro 0 0 0\na - :\nb car1 : jeg4\nc - :\nd - :\ne hk1 :\n"
    },
    # 21. Hókotró vásárlása
    {
        "palya": "a U - b :\nb U - c :\nc U - :\n",
        "input": "init test21_palya.txt\nadd -tj tj1\nadd -tj tj2\nbuy -hk hk1 tj1 a\nbuy -hk hk2 tj2 b\nsave test21_expected.txt\n",
        "expected": "tj1 900 hk1\n\thk1 sopro 0 0 0\ntj2 900 hk2\n\thk2 sopro 0 0 0\na hk1 :\nb hk2 :\nc - :\n"
    },
    # 22. Só vásárlása
    {
        "palya": "a U - :\n",
        "input": "init test22_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -so hk1\nsave test22_expected.txt\n",
        "expected": "tj1 890 hk1\n\thk1 sopro 30 0 0\na hk1 :\n"
    },
    # 23. Biokerozin vásárlása
    {
        "palya": "a U - :\n",
        "input": "init test23_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -kerozin hk1\nsave test23_expected.txt\n",
        "expected": "tj1 890 hk1\n\thk1 sopro 0 30 0\na hk1 :\n"
    },
    # 24. Zúzalék vásárlása
    {
        "palya": "a U - :\n",
        "input": "init test24_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -zuzalek hk1\nsave test24_expected.txt\n",
        "expected": "tj1 890 hk1\n\thk1 sopro 0 0 30\na hk1 :\n"
    },
    # 25. Hókotrófej cseréje
    {
        "palya": "a U - :\n",
        "input": "init test25_palya.txt\nadd -tj tj1\nbuy -hk hk1 tj1 a\nbuy -fej hk1 soszoro\nswap hk1 soszoro\nsave test25_expected.txt\n",
        "expected": "tj1 850 hk1\n\thk1 soszoro 0 0 0\na hk1 :\n"
    }
]

if not os.path.exists("tests"):
    os.makedirs("tests")

for i, t in enumerate(tests):
    idx = i + 1
    with open(f"tests/test{idx}_palya.txt", "w") as f:
        f.write(t["palya"])
    with open(f"tests/test{idx}_teszt.txt", "w") as f:
        f.write(t["input"])
    with open(f"tests/test{idx}_expected.txt", "w") as f:
        f.write(t["expected"])

print("Tests generated.")

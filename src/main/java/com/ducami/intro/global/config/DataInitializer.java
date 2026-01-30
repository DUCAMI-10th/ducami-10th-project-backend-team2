package com.ducami.intro.global.config;

import com.ducami.intro.domain.code.entity.CodeExample;
import com.ducami.intro.domain.code.repository.CodeExampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CodeExampleRepository codeExampleRepository;

    @Override
    public void run(String... args) {
        if (codeExampleRepository.count() == 0) {
            log.info("Initializing code examples...");
            initCodeExamples();
            log.info("Code examples initialized successfully");
        } else {
            log.info("Code examples already exist, skipping initialization");
        }
    }

    private void initCodeExamples() {
        codeExampleRepository.save(CodeExample.builder()
                .title("두 수의 덧셈")
                .code("a, b = map(int, input().split())\nprint(a + b)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("입출력")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("Hello World")
                .code("print('Hello, World!')")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("기초")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("두 수의 곱셈")
                .code("a, b = map(int, input().split())\nprint(a * b)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("연산")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("1부터 N까지 합")
                .code("n = int(input())\ntotal = sum(range(1, n+1))\nprint(total)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("반복문")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("짝수 판별")
                .code("n = int(input())\nif n % 2 == 0:\n    print('짝수')\nelse:\n    print('홀수')")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("조건문")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("최댓값 찾기")
                .code("numbers = list(map(int, input().split()))\nprint(max(numbers))")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("리스트")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("구구단 출력")
                .code("n = int(input())\nfor i in range(1, 10):\n    print(f'{n} x {i} = {n*i}')")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("반복문")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("문자열 뒤집기")
                .code("s = input()\nprint(s[::-1])")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("문자열")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("리스트 평균")
                .code("numbers = list(map(int, input().split()))\navg = sum(numbers) / len(numbers)\nprint(avg)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("리스트")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("소문자로 변환")
                .code("s = input()\nprint(s.lower())")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("문자열")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("대문자로 변환")
                .code("s = input()\nprint(s.upper())")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("문자열")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("최솟값 찾기")
                .code("numbers = list(map(int, input().split()))\nprint(min(numbers))")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("리스트")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("절댓값 구하기")
                .code("n = int(input())\nprint(abs(n))")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("연산")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("나머지 연산")
                .code("a, b = map(int, input().split())\nprint(a % b)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("연산")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("몫 구하기")
                .code("a, b = map(int, input().split())\nprint(a // b)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("연산")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("제곱 계산")
                .code("a, b = map(int, input().split())\nprint(a ** b)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("연산")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("리스트 정렬")
                .code("numbers = list(map(int, input().split()))\nnumbers.sort()\nprint(numbers)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("리스트")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("문자열 길이")
                .code("s = input()\nprint(len(s))")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("문자열")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("리스트 역순")
                .code("numbers = list(map(int, input().split()))\nprint(numbers[::-1])")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("리스트")
                .build());

        codeExampleRepository.save(CodeExample.builder()
                .title("문자열 반복")
                .code("s = input()\nn = int(input())\nprint(s * n)")
                .difficulty(CodeExample.Difficulty.EASY)
                .category("문자열")
                .build());
    }
}
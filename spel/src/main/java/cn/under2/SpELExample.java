package cn.under2;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample {

    public static void main(String[] args) {
        // 创建 SpEL 解析器
        SpelExpressionParser parser = new SpelExpressionParser();

        // 创建评估上下文
        StandardEvaluationContext context = new StandardEvaluationContext();

        // 设置变量值
        context.setVariable("name", "Bob");
        context.setVariable("age", 25);

        // 解析表达式并进行评估
        Expression expression = parser.parseExpression("'Hello, ' + #name + '! You are ' + #age + ' years old.'");
        String message = expression.getValue(context, String.class);

        // 输出结果
        System.out.println(message);
    }
}
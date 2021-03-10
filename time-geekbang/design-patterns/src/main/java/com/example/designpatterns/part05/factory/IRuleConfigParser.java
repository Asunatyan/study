package com.example.designpatterns.part05.factory;

/**
 * Description:
 * date: 2021/3/10 14:45
 *
 * @author dqk
 */
interface IRuleConfigParser {
    RuleConfig parse(String configText);
}

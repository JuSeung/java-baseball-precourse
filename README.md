# 숫자 야구 게임
## 기능 요구사항

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를
  이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  - [예] 상대방(컴퓨터)의 수가 425일 때,
    - 123을 제시한 경우 : 1스트라이크 
    - 456을 제시한 경우 : 1볼 1스트라이크 
    - 789를 제시한 경우 : 낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
  게임플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능목록

### 컴퓨터는 1에서 9까지 서로 다른 수로 이루어진 3자리 숫자 자동생성한다.
- [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [x] 3자리는 서로 다른 수 이기때문에 중복을 확인한다.

### 플레이어에게 3자리 수를 입력 받는다. 
- [x] 입력안내 메시지 출력
- [x] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
  - [x] 3자리 숫자가 아니면 예외 발생
  - [x] 숫자가 아니면 예외발생
  - [x] 1자리 숫자 범위가 1~9까지 아니면 예외발생
  - [x] 3자리에서 중복된 숫자가 있으면 예외발생
  
  
### 컴퓨터는 플레이어가 입력한 숫자 3자리를 비교하여 볼, 스트라이크 수를 반환한다.
- [x] N개가 같은 수가 같은 자리에 있으면: "N스트라이크"
- [x] N개가 다른 자리에 있으면 볼 : "N볼"
- [x] 같은 수가 전혀 없으면 : "낫싱"

### 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- [x] 3스트라이크가 나오면 게임 종료
- [x] "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 메시지 출력 

## 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- [x] 플레이어가 1 입력 시 다시 시작한다.
- [x] 플레이어가 2 입력 시 완전히 종료한다.
- [x] 플레이어가 잘못된 값을 입력 시 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
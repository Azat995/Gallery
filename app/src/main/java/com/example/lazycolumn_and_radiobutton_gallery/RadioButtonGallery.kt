package com.example.lazycolumn_and_radiobutton_gallery

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.lazycolumn_and_radiobutton_gallery.ui.theme.Typography
import com.example.lazycolumn_and_radiobutton_gallery.ui.theme.textStyle


@Composable
fun RadioButtonFun(img: List<Int>, author: Int, info: Int) {

    var stateVisible by remember { mutableStateOf(true) }
    var stateIcon by remember { mutableStateOf(true) }
    var selectedStateRadioButton by remember { mutableStateOf(img[0]) }//сохроняем  состояния выбранного radioButton

    if (stateIcon) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_home_24),
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier
                .size(36.dp)
                .padding(start = 10.dp, top = 4.dp)
                .clickable { stateIcon = !stateIcon }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                //создаем контейнер типа - карточка
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .shadow(//добавление эффекта тени карточке
                        shape = RoundedCornerShape(30.dp),
                        elevation = 17.dp,
                        clip = true,
                        ambientColor = Color.Cyan,
                        spotColor = Color.Cyan
                    ),
            ) {
                Row(//контейнер - линейного типа для добавления виджетов radioButton
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(0.1f)//указываем что Row будет находиться на картинке
                        .height(30.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center

                ) {

                    img.forEach { item ->//цикл создает количество radioButton равное количеству картинок
                        Column()//в цикле для каждого radioButton виджета создается контейнер типа - столбец
                        {
                            RadioButton(// создаем radioButton виджет по количеству элементов входяшего списка данных
                                //обратный вызов, который будет вызываться при нажатии кнопки RadioButton.
                                selected = selectedStateRadioButton == item,
                                onClick = {
                                    selectedStateRadioButton = item
                                    stateVisible = !stateVisible

                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(255, 255, 102),
                                    unselectedColor = Color.White,
                                )
                            )
                        }
                    }
                }


                Image(
                    painter = painterResource(id = selectedStateRadioButton),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )


            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .verticalScroll(state = ScrollState(0)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = author),
                    modifier = Modifier
                        .padding(25.dp),
                    style = Typography.textStyle,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = stringResource(id = info),
                    modifier = Modifier
                        .border(2.dp, color = Color.LightGray)
                        .padding(15.dp)
                )
            }
        }
    } else {
        GalleryLazyColumn()
    }

}